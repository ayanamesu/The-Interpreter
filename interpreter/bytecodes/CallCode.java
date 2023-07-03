package interpreter.bytecodes;
import java.util.ArrayList;
import java.util.Arrays;

import interpreter.virtualmachine.VirtualMachine;

public class CallCode implements ByteCode {
    private String id;
    private int address;

    public CallCode(String[] args) {
        if (args.length > 0) {
            id = args[1];
        }
    }
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getProgramCounter() + 1);
        vm.setProgramCounter(address - 1);
    }
    @Override
    public String toString() {
        String baseId = id.split("<<")[0];
        String args = id.substring(baseId.length() + 2).replace("<", "").replace(">>", ",");
        return "CALL " + id + " " + baseId + "(" + args + ")";
    }

    public void setAddress() {
        this.address = address;
    }
    public static void main(String[] args) {

        int[] runtimeStack = {0, 1, 2, 3, 4, 5};
        int currentFrameOffset = 3;

        // Create an instance of CallCode
        CallCode callCode = new CallCode(new String[]{"CALL", "f<<3>>"});


        int address = runtimeStack[currentFrameOffset] + 1; // Replace with your address resolution logic


        // Print the dumping syntax
        System.out.println(callCode.toString());
    }
//    public static void main(String[] args) {
//        // Create an instance of CallCode
//        CallCode callCode = new CallCode(new String[]{"CALL", "f<<3>>"});
//        // Set the appropriate address value
//        int address = 4; // Replace with the actual address value
//        callCode.setAddress(address);
//
//        // Print the dumping syntax
//        System.out.println(callCode.toString());
//    }
}




