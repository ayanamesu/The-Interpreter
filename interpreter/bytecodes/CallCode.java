package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode {
    private String label;
    private int address;
    private String vars;


    public CallCode(String[] args) {
        if (args.length > 0) {
            this.label = args[1];
            if (args.length > 2) {
                this.vars = args[2];
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
        vm.setCallCodeVars("");
        vm.setCallCodeVars(vars);
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

        return "CALL " + label + " " + id + "(" + "" + ")";
    }
}



