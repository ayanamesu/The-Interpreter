package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;


public class ReturnCode implements ByteCode {
    private ArrayList<String> arguments;

    public ReturnCode() {
        arguments = new ArrayList<>();
    }

    public ReturnCode(ArrayList<String> args) {
        arguments = args;
    }

    @Override
    public void execute(VirtualMachine vm) {
        int returnValue = vm.pop(); // Pop the top value from the runtime stack
        vm.popFrame(); // Empty the current frame
        vm.setProgramCounter(vm.popReturnAddress()); // Pop the top of the return address stack and save it into the program counter
        vm.push(returnValue); // Store the return value at the top of the runtime stack
    }

    @Override
    public String toString() {
        String return_str = "RETURN";

        if (!arguments.isEmpty()) {
            return_str += " " + arguments.get(0) + "    exit ";
            String arg0 = arguments.get(0);
            int base_id = arg0.indexOf("<<");
            if (base_id != -1) {
                String base_id_str = arg0.substring(0, base_id);
                return_str += base_id_str + ":";
            }
        }

        return return_str;
    }
}
//    private ArrayList<String> arguments;
//
//    public ReturnCode() {
//        arguments = new ArrayList<>();
//    }
//
//    public ReturnCode(ArrayList<String> args) {
//        arguments = args;
//    }
//
//
//    @Override
//    public void execute(VirtualMachine vm) {
//        int returnValue = vm.pop(); // Pop the top value from the runtime stack
//        vm.popFrame(); // Empty the current frame
//        vm.setProgramCounter(vm.popReturnAddress()); // Pop the top of the return address stack and save it into the program counter
//        vm.push(returnValue); // Store the return value at the top of the runtime stack
//    }
//
//    @Override
//    public String toString() {
//        String return_str = "RETURN";
//
//        if (!arguments.isEmpty()) {
//            return_str += " " + arguments.get(0) + "    exit ";
//            String arg0 = arguments.get(0);
//            int base_id = arg0.indexOf("<<");
//            if (base_id != -1) {
//                String base_id_str = arg0.substring(0, base_id);
//                return_str += base_id_str + ":";
//            }
//        }
//
//        return return_str;
//    }







