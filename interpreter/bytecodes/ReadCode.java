package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;
import java.util.Scanner;
public class ReadCode implements ByteCode {
    Scanner scanner = new Scanner(System.in);
    public ReadCode(String[] args) {
    }

    @Override
    public void execute(VirtualMachine vm) {
        System.out.print("Please enter an int: ");
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

        public static void main(String[] args) {
            // Create an instance of the VirtualMachine
            VirtualMachine vm = new VirtualMachine(new Program());

            // Enable dumping
            vm.dumpOn();

            // Create an instance of the ReadCode bytecode
            ReadCode readCode = new ReadCode(new String[]{});

            // Execute the ReadCode bytecode
            readCode.execute(vm);

            // Dump the bytecode
            System.out.println(readCode.toString());
    }

}
