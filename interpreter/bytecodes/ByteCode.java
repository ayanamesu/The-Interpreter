package interpreter.bytecodes;

public interface ByteCode {

    static ByteCode getInstance(String type, String[] args ) {
        return switch (type) {
            case "LIT" -> new LitCode(args);
            case "HALT" -> new HaltCode(args);
            case "WRITE" -> new WriteCode(args);
            default -> throw new IllegalArgumentException();
        };
    }
}
