package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class RunTimeStack {

    private List<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial frame pointer value, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }

    public String dump() {
        StringBuilder result = new StringBuilder();
        int frameIndex = 0;
        for (int i = 0; i < framePointer.size(); i++) {
            int beginning = framePointer.get(i);
            int end = (i + 1 < framePointer.size()) ? framePointer.get(i + 1) : runTimeStack.size();
            result.append("[");
            for (int j = beginning; j < end; j++) {
                result.append(runTimeStack.get(j));
                if (j != end - 1)
                    result.append(", ");
            }
            result.append("]");
            if (i != framePointer.size() - 1)
                result.append(" ");
        }
        return result.toString();
    }


    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public int pop() {
        return this.runTimeStack.remove(this.runTimeStack.size() - 1);
    }

    public int store(int offsetFromFramePointer) {
        int value = runTimeStack.get(runTimeStack.size() - 1);
        int frameIndex = framePointer.peek();
        int storeIndex = frameIndex + offsetFromFramePointer;
        runTimeStack.set(storeIndex, value);
        return value;
    }

    public int load(int offsetFromFramePointer) {
        int frameIndex = framePointer.peek();
        int loadIndex = frameIndex + offsetFromFramePointer;
        int value = runTimeStack.get(loadIndex);
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offsetFromTopOfRunStack) {
        int frameIndex = runTimeStack.size() - offsetFromTopOfRunStack;
        framePointer.push(frameIndex);
    }

    public void popFrame() {
        int frameIndex = framePointer.pop();
        for (int i = runTimeStack.size() - 1; i >= frameIndex; i--) {
            runTimeStack.remove(i);
        }
    }

    public static void main(String[] args) {
        RunTimeStack rts = new RunTimeStack();
        rts.push(1);
        rts.push(2);
        rts.push(3);
        rts.framePointer.push(3);
        rts.push(4);
        rts.push(5);
        rts.push(6);
        rts.framePointer.push(6);
        rts.push(7);
        rts.push(8);
        rts.push(123456789);
        rts.framePointer.push(8);

        String stackDump = rts.dump();
        System.out.println(stackDump);

        System.out.print("Frame pointers: ");
        for (int i = 0; i < rts.framePointer.size(); i++) {
            int frame = rts.framePointer.get(i);
            System.out.print(frame);
            if (i != rts.framePointer.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
//
//        assert rts.runTimeStack.size() == 4;
//        rts.runTimeStack.forEach(v -> System.out.println(v));
//        System.out.println(rts.pop());

    }
}

