package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

public class LabelCode implements ByteCode {
    private String label;
    public LabelCode(String[] args) {
        if (args.length > 0) {
            label = args[0];
        }
    }
    public String getLabel() {
        return label;
    }
    @Override
    public void execute(VirtualMachine vm) {

    }

    public String toString() {
        return "LABEL " + label;
    }

}
