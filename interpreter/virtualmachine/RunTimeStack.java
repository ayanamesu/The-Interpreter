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

    public int push(int val) {
        runTimeStack.add(val);
        return val;
    }

    public int pop() {
        return this.runTimeStack.remove(this.runTimeStack.size() - 1);
    }

    public static void main(String[] args) {
        RunTimeStack rts = new RunTimeStack();
        rts.push(2);
        rts.push(3);
        rts.push(2312312);

        assert rts.runTimeStack.size() == 4;
        rts.runTimeStack.forEach(v -> System.out.println(v));
        System.out.println(rts.pop());
    }
}
