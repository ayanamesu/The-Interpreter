package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode implements ByteCode {
    private ArrayList<String> arguments;

    private String functionName = "";
    private int returnValue = 0;

    public ReturnCode(String[] args) {
        if (args.length > 1) {
            functionName = args[1];
        }
    }
    public void init(ArrayList<String> args) {
        arguments = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.popFrame();
        int return_addr = vm.popReturnAddress();
        vm.setProgramCounter(return_addr);
    }

    @Override
    public String toString() {
        String return_str = "RETURN";

        if (arguments.size() == 1) {
            return_str += " " + arguments.get(0) + " EXIT ";
            String arg0 = arguments.get(0);
            int base_id_start = arg0.indexOf("<<") + 2; // Find the starting index of the base-id
            int base_id_end = arg0.indexOf(">>"); // Find the ending index of the base-id
            String base_id = arg0.substring(base_id_start, base_id_end); // Extract the base-id
            return_str += base_id + " : " + getReturnValue();
        }

        return return_str;
    }

    private int getReturnValue() {
        return returnValue;
    }


}



