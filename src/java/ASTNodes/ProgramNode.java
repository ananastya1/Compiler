package ASTNodes;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode extends ASTNode {
    private List<ASTNode> programNodes;

    public ProgramNode() {
        super("Program", 0);
        programNodes = new ArrayList<>();
    }

    public void addProgramNode(ASTNode node) {
        programNodes.add(node);
    }

    public List<ASTNode> getProgramNodes() {
        return programNodes;
    }


    @Override
    public void printNode(int depth) {

        String indent = "  ".repeat(depth);
        System.out.println(indent + this.label);
        System.out.print(indent + "|__");

        for (ASTNode programNode : programNodes) {
            programNode.printNode(depth + 2);
        }
    }
}
