package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode {
    private String label;
    private int address;

    public CallCode(String[] args) {


    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getProgramCounter());
        vm.setProgramCounter(address);
    }

    @Override
    public String toString() {
        return "CALL " + label + " <<" + address + ">> " + label + "()";
    }
}




