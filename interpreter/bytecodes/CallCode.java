package interpreter.bytecodes;
import java.util.ArrayList;
import java.util.Arrays;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode {
    private String label;
    private int address;

    public CallCode(String[] args) {
        if (args.length > 0) {
            label = args[1];
        }
    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getProgramCounter() + 1);
        vm.setProgramCounter(address - 1);
    }
    public String getLabel() {
        return label;
    }
    @Override
    public String toString() {
        String baseId = label.split("<<")[0];
        String args = label.substring(baseId.length() + 2).replace("<", "").replace(">>", ",");
        return "CALL " + label + " " + baseId + "(" + args + ")";
    }

    public void setAddress(int newAddress) {
        this.address = newAddress;
    }

}




