package interpreter.virtualmachine;

import interpreter.bytecodes.ByteCode;
import interpreter.bytecodes.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean         dump;


    public VirtualMachine(Program program) {
        this.program = program;
        this.runTimeStack = new RunTimeStack();
        this.returnAddress = new Stack<>();
        this.programCounter = 0;
    }


    public void executeProgram() {  //changed from protected to public

        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<>();
        isRunning = true;
        while(isRunning) {
            ByteCode newCode = program.getCode(programCounter);
            newCode.execute(this);
            if (dump && !(newCode instanceof DumpCode)) {
                System.out.println(newCode.toString());
                runTimeStack.dump();
            }
            programCounter++;
        }
    }

    public void push(int valueToPush) {
        this.runTimeStack.push(valueToPush);
    }

    public void halt() {
        this.isRunning = false;
    }



    public int peek() {
        return runTimeStack.peek();
    }

    public int pop() {
        return runTimeStack.pop();
    }

    public void setProgramCounter(int pc) {
        this.programCounter = pc;
    }

    public int getProgramCounter() {
        return programCounter;
    }



    public void popFrame() {
        runTimeStack.popFrame();
    }

    public int load(int offset) {
        return runTimeStack.load(offset);
    }

    public void pushReturnAddress(int address) {
        returnAddress.push(address);
    }

    public void newFrameAt(int offset) {
        runTimeStack.newFrameAt(offset);
    }


    public void dumpOn() {
        dump = true;
    }
    public void dumpOff() {
        dump = false;
    }


    public int store(int offset) {
        return runTimeStack.store(offset);
    }

    public int popReturnAddress() {
        return returnAddress.pop();
    }

}