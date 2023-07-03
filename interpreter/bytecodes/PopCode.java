package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class PopCode implements ByteCode {
    private int popCode;
    public PopCode(String[] args) {
        if (args.length > 0) {
            popCode = Integer.parseInt(args[0]);
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

    public static void main(String[] args) {
        // Create an instance of PopCode
        PopCode popCode = new PopCode(new String[]{"3"});

        // Print the Pop bytecode dump syntax
        System.out.println(popCode.toString());
    }
}
