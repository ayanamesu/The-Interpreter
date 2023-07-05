package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;

public class ReturnCode implements ByteCode {
    private String functionName;

    public ReturnCode() {
    }

    @Override
    public void execute(VirtualMachine vm) {
        int returnValue = vm.pop(); // Pop the top value from the runtime stack
        vm.popFrame(); // Empty the current frame
        vm.setProgramCounter(vm.popReturnAddress()); // Pop the top of the return address stack and save it into the program counter
        vm.push(returnValue); // Store the return value at the top of the runtime stack
    }

    @Override
    public String toString() {
        return "RETURN " + functionName ;
    }
}



