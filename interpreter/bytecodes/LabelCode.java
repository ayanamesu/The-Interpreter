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

    @Override
    public void execute(VirtualMachine vm) {

    }

    public String toString() {
        return "LABEL " + label;
    }

    public static void main(String[] args) {
        // Create an instance of LabelCode with a label
        LabelCode labelCode = new LabelCode(new String[]{"label"});

        // Enable dumping
        VirtualMachine vm = new VirtualMachine(new Program());
        vm.dumpOn();

        // Execute the LabelCode bytecode
        labelCode.execute(vm);

        // Dump the bytecode
        System.out.println(labelCode.toString());
    }
}
