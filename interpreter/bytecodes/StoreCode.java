package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;

public class StoreCode implements ByteCode {
    private int offset;
    private String id;
    private int xValue;

    public StoreCode(String[] args) {
        if (args.length > 1) {
            offset = Integer.parseInt(args[1]);
            if (args.length > 2) {
                id = args[2];
            }
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
        this.xValue = vm.peek();
    }



    @Override
    public String toString() {
        //STORE 2 x    x = 8
        return "STORE " + offset + " " + id + "\t"+ id +" = "+ this.xValue;
    }

}