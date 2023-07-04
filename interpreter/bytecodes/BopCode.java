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

}
