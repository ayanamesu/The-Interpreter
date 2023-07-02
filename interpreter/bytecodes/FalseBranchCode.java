package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;


public class FalseBranchCode implements ByteCode {
    private String id;
    private int valueToPush;
    public FalseBranchCode(String[] args) {
        if (args.length > 0) {
            id = args[0];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int value = vm.pop(); // Remove the top value from the stack
        if (value == 0) {
            vm.setProgramCounter(valueToPush); // Jump to the resolved address if value is 0
        }
    }

    public void setAddress() {
    }
}
