package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
public interface ByteCode {

    void execute(VirtualMachine vm);
    static ByteCode getInstance(String type, String[] args ) {
        return switch (type) {
            case "LIT" -> new LitCode(args);
            case "HALT" -> new HaltCode(args);
            case "WRITE" -> new WriteCode(args);
            case "ARGS" -> new ArgsCode();
            case "BOP" -> new BopCode(args);
            case "CALL" -> new CallCode(args);
            case "DUMP" -> new DumpCode(args);
            case "FALSEBRANCH" -> new FalseBranchCode(args);
            case "GOTO" -> new GoToCode(args);
            case "LABEL" -> new LabelCode(args);
            case "LOAD" -> new LoadCode(args);
            case "POP" -> new PopCode(args);
            case "READ" -> new ReadCode(args);
            case "RETURN" -> new ReturnCode(args);
            case "STORE" -> new StoreCode(args);
            default -> throw new IllegalArgumentException();
        };
    }
}
