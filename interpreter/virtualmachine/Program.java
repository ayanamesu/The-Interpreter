package interpreter.virtualmachine;

import interpreter.bytecodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Program {

    private List<ByteCode> program;

    /**
     * Instantiates a program object using an
     * ArrayList
     */
    public Program() {
        program = new ArrayList<>();
    }

    /**
     * Gets the size of the current program.
     *
     * @return size of program
     */
    public int getSize() {
        return program.size();
    }

    /**
     * Grabs an instance of a bytecode at an index.
     *
     * @param programCounter index of bytecode to get.
     * @return a bytecode.
     */
    public ByteCode getCode(int programCounter) {
        return program.get(programCounter);
    }

    /**
     * Adds a bytecode instance to the Program List.
     *
     * @param c bytecode to be added
     */
    public void addByteCode(ByteCode c) {
        program.add(c);
    }

    /**
     * Makes multiple passes through the program ArrayList resolving
     * addrss for Goto,Call and FalseBranch bytecodes. These bytecodes
     * can only jump to Label codes that have a matching label value.
     * HINT: make note of what type of data-structure ByteCodes are stored in.
     * **** METHOD SIGNATURE CANNOT BE CAHNGED *****
     */
    public void resolveAddress() {
        HashMap<String, Integer> labelMap = new HashMap<>();

        // First pass: store label positions in a HashMap
        for (int i = 0; i < program.size(); i++) {
            ByteCode bc = program.get(i);
            if (bc instanceof LabelCode labelCode) {
                String label = labelCode.getLabel();
                labelMap.put(label, i);
            }
        }

        // Second pass: resolve addresses for GoTo, Call, and FalseBranch bytecodes
        for (int i = 0; i < program.size(); i++) {
            ByteCode bc = program.get(i);
            if (bc instanceof GoToCode goToCode) {
                String label = goToCode.getLabel();
                int address = labelMap.get(label);
                goToCode.setAddress(address);
            } else if (bc instanceof CallCode callCode) {
                String label = callCode.getLabel();
                int address = labelMap.get(label);
                callCode.setAddress(address);
            } else if (bc instanceof FalseBranchCode falseBranchCode) {
                String label = falseBranchCode.getLabel();
                int address = labelMap.get(label);
                falseBranchCode.setAddress(address);
            }
        }
    }
}
