package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

public class StoreCode implements ByteCode {
    private int offset;
    private String id;
    private VirtualMachine vm;
    public StoreCode(String[] args) {
        if (args.length > 0) {
            offset = Integer.parseInt(args[1]);
            if (args.length > 1) {
                id = args[2];
            }
        }

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }

    public String toString() {
        return "STORE " + offset + " " + id;


    }

}

