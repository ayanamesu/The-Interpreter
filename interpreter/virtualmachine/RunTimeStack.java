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




    public String dump() {
        String str = "";

        if (!framePointer.isEmpty()) {
            for (int i = 0; i < framePointer.size(); i++) {
                str += "[";
                int start = framePointer.get(i);
                int end = (i == framePointer.size() - 1) ? runTimeStack.size() - 1 : framePointer.get(i + 1) - 1;

                for (int j = start; j <= end; j++) {
                    str += runTimeStack.get(j);
                    str += ",";
                }

                if (str.charAt(str.length() - 1) == ',') {
                    str = str.substring(0, str.length() - 1);
                }

                str += "] ";
            }
        }

        System.out.println(str);
        return str;
    }

    public int peek() {
        return runTimeStack.get(runTimeStack.size() - 1);
    }


    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public int pop() {
        int size_of_curr_frame = runTimeStack.size() - framePointer.peek();
        int topStack = 0;
        if (size_of_curr_frame >= 1) {  //verifying that we have a frame big enough to pop(size >=1)
            topStack = runTimeStack.get(runTimeStack.size() - 1);
            runTimeStack.remove(runTimeStack.size() - 1);
        }
        return topStack;
    }

    public int store(int offsetFromFramePointer) {
        int value = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(offsetFromFramePointer + framePointer.peek(), value);
        return value;
    }

    public int load(int offset) {
        int value = runTimeStack.get(framePointer.peek()) + offset;
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
}

