import java.util.List;

public class RecordTypeNode extends UserTypeNode {

    private List<VariableDeclarationNode> variableDeclarations;

    public RecordTypeNode(List<VariableDeclarationNode> variableDeclarations, int lineNumber) {
        super("RecordType", lineNumber, Type.RECORD);
        this.variableDeclarations = variableDeclarations;
    }

    public List<VariableDeclarationNode> getVariableDeclarations() {
        return variableDeclarations;
    }
}
