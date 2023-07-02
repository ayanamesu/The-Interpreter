package interpreter.virtualmachine;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }

    public void push(int valueToPush) {
        this.runTimeStack.push(valueToPush);
    }

    public void halt() {
        this.isRunning = isRunning;
    }

    public int peek() {
        return runTimeStack.peek();
    }

    public void setProgramCounter(int pc) {
        this.programCounter = pc;
    }
}
