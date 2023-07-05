package interpreter.bytecodes;
import java.util.List;
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

    public void init(List<String> args) {
        if (args.size() > 0) {
            offset = Integer.parseInt(args.get(0));
            if (args.size() > 1) {
                id = args.get(1);
            }
        }
    }
    @Override
    public String toString() {
        if (id != null) {
            return "LOAD " + offset + " " + id;
        } else {
            return "LOAD " + offset;
        }
    }


}
