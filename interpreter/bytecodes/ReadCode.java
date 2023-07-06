package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;
import java.util.Scanner;
public class ReadCode implements ByteCode {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute(VirtualMachine vm) {
        System.out.print("Please enter an integer: ");
        int userInput = scanner.nextInt();
        vm.push(userInput);

//        int input = scanner.nextInt();
//        vm.push(input);

//        System.out.println("Input: " + input);
//        System.out.println("Runtime Stack: " + vm.getRunTimeStack().dump());
    }

    public String toString() {
        return "READ ";
    }


}
