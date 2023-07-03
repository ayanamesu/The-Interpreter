package interpreter.bytecodes;
import java.util.List;
import interpreter.virtualmachine.VirtualMachine;

public class LoadCode implements ByteCode {
    private int offset;
    private String id;
    public LoadCode(String[] args) {
        if (args.length > 0) {
            offset = Integer.parseInt(args[0]);
            if (args.length > 1) {
                id = args[1];
            }
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
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

    public static void main(String[] args) {
        // Create an instance of LoadCode with arguments
        LoadCode loadCode = new LoadCode(new String[]{"2", "j"});

        // Print the Load bytecode dump syntax
        System.out.println(loadCode.toString());
    }
}
