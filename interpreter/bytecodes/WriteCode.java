package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
public class WriteCode implements ByteCode {

    public WriteCode() {
    }


    @Override
    public void execute(VirtualMachine vm) {
        System.out.println(vm.peek());
    }

    @Override
    public String toString() {
        return "WRITE";
    }

}


