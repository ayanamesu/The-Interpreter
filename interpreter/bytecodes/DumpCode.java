package interpreter.bytecodes;

import interpreter.virtualmachine.VirtualMachine;

public class DumpCode implements ByteCode {
    private String dumps;


    public DumpCode(String[] args) {
        if (args.length > 0) {
            dumps = args[1];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        if (dumps.equals("ON")) {
            vm.dumpOn();
        } else {
            vm.dumpOff();
        }
    }
}