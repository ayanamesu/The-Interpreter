package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode implements ByteCode {
    private String functionName = "";
    private int returnValue = 0;
    private String baseId;

    public ReturnCode(String[] args) {
        if (args.length > 0) {
            functionName = args[0];
            if (functionName.contains("<<") && functionName.contains(">>")) {
                baseId = functionName.substring(0, functionName.indexOf("<<"));
            }
        }
    }





    @Override
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        vm.setProgramCounter(vm.popReturnAddress());
        returnValue = vm.peek();
    }

    public String toString() {
        if (functionName.isEmpty()) {
            return "RETURN";
        } else {
            return "RETURN " + functionName + " EXIT " + baseId + ":" + returnValue;
        }
    }


    public static void main(String[] args) {
        // Create an instance of the VirtualMachine
        VirtualMachine vm = new VirtualMachine(new Program());

        // Push necessary values to the stack
        vm.push(0); // Frame pointer
        vm.push(0); // Return address
        vm.push(4); // Return value

        // Create a ReturnCode instance
        ReturnCode returnCode = new ReturnCode(new String[]{"f<<2>>"});
        returnCode.execute(vm);

        // Dump the ReturnCode
        System.out.println(returnCode.toString());
    }

}
