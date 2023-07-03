package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

public class StoreCode implements ByteCode {
    private int offset;
    private String id;
    private VirtualMachine vm;
    public StoreCode(String[] args) {
        if (args.length > 0) {
            offset = Integer.parseInt(args[0]);
            if (args.length > 1) {
                id = args[1];
            }
        }

    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.store(offset);
    }

    public String toString() {
        return "STORE " + offset + " " + id;


    }



    public static void main(String[] args) {
        // Create an instance of the VirtualMachine
        VirtualMachine vm = new VirtualMachine(new Program());
        vm.push(0);
        vm.push(1);
        vm.push(2);
        vm.push(3);

        StoreCode store1 = new StoreCode(new String[]{"1", "k"});
        store1.execute(vm);
        System.out.println(store1.toString());




    }
}

