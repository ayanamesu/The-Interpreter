package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode {
    private String label;
    private int address;
    private int returnValue;


    public CallCode(String[] args) {
        if (args.length > 0) {
            this.label = args[1];
            if (args.length > 2) {
                returnValue = Integer.parseInt(args[2]);
            }
        }

    }

    public void setAddress(int address) {
        this.address = address;
    }

    public String getLabel() {
        return label;
    }


    @Override
    public void execute(VirtualMachine vm) {
        this.returnValue = vm.peek();
        vm.pushReturnAddress(vm.getProgramCounter());
        vm.setProgramCounter(address);
    }

    @Override
    public String toString() {
        String id = "";
        for (int i = 0; i < label.length(); i++) {
            if (label.charAt(i) == '<') {
                break;
            }
            id += String.valueOf(label.charAt(i));
        }
        if (this.returnValue == 0)
            return "CALL " + label + " " + id + "()";
        else
            return "CALL " + label + " " + id + "(" + this.returnValue + ")";
    }
}