package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode implements ByteCode {
    private int popCode;
    public PopCode(String[] args) {
        if (args.length > 1) {
            popCode = Integer.parseInt(args[1]);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        for (int i = 0; i > popCode; i++) {
            vm.pop();
        }
    }

    public String toString() {
        return "POP " + popCode;
    }

}
