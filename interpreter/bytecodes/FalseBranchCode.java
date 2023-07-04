package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;


public class FalseBranchCode implements ByteCode {
    private String label;
    private int address;
    public FalseBranchCode(String[] args) {
        if (args.length > 0) {
            label = args[0];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.pop(); // Remove the top value from the stack
        if (value == 0) {
            vm.setProgramCounter(address); // Jump to the resolved address if value is 0
        } // If value is not 0, move to the next ByteCode (do nothing)
    }

    public void setAddress(int newAddress) {
        this.address = newAddress;
    }

    public String getLabel() {
        return label;
    }
    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }
}

