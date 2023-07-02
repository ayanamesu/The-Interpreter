package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
public class GoToCode implements ByteCode {
    private String id;
    private int valueToPush;
    public GoToCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {

    }

    public void setAddress() {

    }
    @Override
    public String toString() {
        String base = "GOTO " + this.valueToPush;

        if(this.id != null) {
            base += " "+ this.id + "\tint " +  this.id;
        }
        return base;
    }
}
