package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

public class LoadCode implements ByteCode {
    private int offset;
    private String id;
    public LoadCode(String[] args) {
        if (args.length > 1) {
            offset = Integer.parseInt(args[1]);
            if (args.length > 2) {
                id = args[2];
            }
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.
                load(offset);
    }
    @Override
    public String toString() {
        if (id != null) {
            return "LOAD " + offset + " " + id + "\t<load " + id +">";
        } else {
            return "LOAD " + offset;
        }
    }


}