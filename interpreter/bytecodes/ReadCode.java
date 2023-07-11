package interpreter.bytecodes;
import interpreter.virtualmachine.VirtualMachine;
import java.util.Scanner;
public class ReadCode implements ByteCode {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(VirtualMachine vm) {
        System.out.print("Please enter an integer: ");
        int userInput = scanner.nextInt();
        vm.push(userInput);
    }

    public String toString() {
        return "READ ";
    }
}
