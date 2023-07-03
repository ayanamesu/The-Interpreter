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
        // Print the top value of the runtime stack
        System.out.println(vm.peek());
    }

    @Override
    public String toString() {
        // Generate the dump syntax
        return "WRITE";
    }

    public static void main(String[] args) {
            // Create an instance of WriteCode
            WriteCode writeCode = new WriteCode(args);

            // Print the dumping syntax using the toString method
            System.out.println(writeCode.toString());
        }
    }


