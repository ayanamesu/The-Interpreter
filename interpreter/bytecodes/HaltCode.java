package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
public class HaltCode implements ByteCode{

    public HaltCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.halt(); // Request the VirtualMachine to halt execution
    }
    @Override
    public String toString() {
        return "";
    }

}


