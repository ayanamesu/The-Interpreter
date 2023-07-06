package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;
import java.util.Arrays;


public class ReturnCode implements ByteCode {
    private String[] arguments;
    private int returnValue;

    public String label;

    public ReturnCode(String[] args) {
        arguments = args;
        if (args.length > 1) {
            label = args[1];
        } else {
            label = null;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        returnValue = vm.pop();
        vm.popFrame();
        vm.setProgramCounter(vm.popReturnAddress());
        vm.push(returnValue);
    }

    @Override
    public String toString() {
        String returnStr = "RETURN";

        if (arguments.length > 1 && label != null) {
            String argument = arguments[1];
            returnStr += " " + argument + " EXIT ";
            int baseIdIndex = argument.indexOf("<<");
            if (baseIdIndex != -1) {
                String baseIdStr = argument.substring(0, baseIdIndex);
                returnStr += baseIdStr + ":";
            }
            returnStr += label + " : " + returnValue;
        }

        return returnStr;
    }
}