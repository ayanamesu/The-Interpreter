package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
public class GoToCode implements ByteCode {
    private String label;
    private int valueToPush;

    public GoToCode(String[] args) {
        if (args.length > 0) {
            label = args[1];
            }
        }

        @Override
        public void execute (VirtualMachine vm){
            vm.setProgramCounter(this.valueToPush);
        }
    public String getLabel() {
        return label;
    }

        public void setAddress(int address) {
        this.valueToPush = address;
    }

        @Override
        public String toString () {
            return "GOTO " + label;
        }
}


