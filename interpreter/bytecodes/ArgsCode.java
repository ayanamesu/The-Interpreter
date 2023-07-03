package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

import java.util.List;
public class ArgsCode implements ByteCode {

    int argsCode = 0;
    public ArgsCode() {
    }


    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(argsCode);
    }

    public void init(List<String> args) {
        // Extract the number of args from the arguments list
        if (args.size() > 0) {
            argsCode = Integer.parseInt(args.get(0));
        }
    }

    public String toString() {
        return "ARGS " + argsCode;
    }

    public static void main(String[] args) {
        // Create an instance of ArgsCode
        ArgsCode argsCode = new ArgsCode();

        // Set the number of args for the new call frame
        argsCode.init(List.of("10"));

        // Print the Args bytecode dump syntax
        System.out.println(argsCode.toString());
    }
}
