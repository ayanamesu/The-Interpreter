package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class ArgsCode implements ByteCode {

    private int argsCode;

    public ArgsCode(String[] args) {
        if (args.length > 0) {
            argsCode = Integer.parseInt(args[1]);
        } else {
            argsCode = 0;
        }
    }



    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameAt(argsCode);
    }



    public String toString() {
        return "ARGS " + argsCode;
    }

}