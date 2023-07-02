package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
public class GoToCode implements ByteCode {
    private String id;
    private int valueToPush;

    public GoToCode(String[] args) {
        if (args.length > 0) {
            id = args[0];
            }
        }

        @Override
        public void execute (VirtualMachine vm){
            vm.setProgramCounter(this.valueToPush);
        }

        public void setAddress () {
            this.valueToPush = valueToPush;
        }

        @Override
        public String toString () {
            return "GOTO " + id;
        }
    }

