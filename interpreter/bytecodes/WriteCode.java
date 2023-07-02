package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;
public class WriteCode implements ByteCode {
    public WriteCode(String[] args) {

    }
//    @Override
//    public void init(ArrayList<String> args) {
//        // Initialize with arguments if needed
//    }

    @Override
    public void execute(VirtualMachine vm) {
        // Print the top value of the runtime stack
        System.out.println(vm.peek());
    }

    @Override
    public String toString() {
        // Generate the dump syntax
        return "WRITE";
    }
}

