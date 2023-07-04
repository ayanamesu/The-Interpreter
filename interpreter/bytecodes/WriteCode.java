package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.List;
public class WriteCode implements ByteCode {
    private ArrayList<String> arguments;

    public WriteCode(String[] args) {
    }

    public void init(ArrayList<String> args) {
        arguments = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    @Override
    public String toString() {
        // Generate the dump syntax
        return "WRITE";
    }

}


