package interpreter.bytecodes;

import interpreter.virtualmachine.Program;
import interpreter.virtualmachine.VirtualMachine;

public class BopCode implements ByteCode {
    private String operator;
    public BopCode(String[] args) {
        if (args.length > 0) {
            operator = args[0];
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        int operand2 = vm.pop();
        int operand1 = vm.pop();
        int result;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            case "==":
                result = operand1 == operand2 ? 1 : 0;
                break;
            case "!=":
                result = operand1 != operand2 ? 1 : 0;
                break;
            case "<=":
                result = operand1 <= operand2 ? 1 : 0;
                break;
            case "<":
                result = operand1 < operand2 ? 1 : 0;
                break;
            case ">=":
                result = operand1 >= operand2 ? 1 : 0;
                break;
            case ">":
                result = operand1 > operand2 ? 1 : 0;
                break;
            case "&":
                result = operand1 & operand2;
                break;
            case "|":
                result = operand1 | operand2;
                break;
            default:
                result = 0;
                break;
        }

        vm.push(result);

    }

    public String toString() {
        return "BOP " + operator;
    }

    public static void main(String[] args) {
        // Create an instance of VirtualMachine
        VirtualMachine vm = new VirtualMachine(new Program());

        // Set the dump option to true
        vm.dumpOn();

        // Push some values onto the stack
        vm.push(5);
        vm.push(3);

        // Create an instance of BopCode with the appropriate operator
        BopCode bopCode = new BopCode(new String[]{"+"});

        // Execute the BopCode
        bopCode.execute(vm);

        // Print the resulting stack
        vm.getRunTimeStack().dump();
    }


}
