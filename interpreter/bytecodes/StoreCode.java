package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

public class StoreCode implements ByteCode {
    private int offset;
    private String id;

    public StoreCode(String[] args) {
        if (args.length > 1) {
            offset = Integer.parseInt(args[1]);
            if (args.length > 2) {
                id = args[3];
            }
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }



    @Override
    public String toString() {
        return "STORE " + offset + " " + id;


    }

}

