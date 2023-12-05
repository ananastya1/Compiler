public class OneLineBodyNode extends ASTNode{


    public OneLineBodyNode(SimpleDeclarationNode simpleDeclaration, int lineNumber) {
        super("simpleDeclaration", lineNumber);
    }

    public OneLineBodyNode(AssignmentNode assignmentNode, int lineNumber) {
        super("assignmentNode", lineNumber);
    }

    public OneLineBodyNode(RoutineCallNode routineCallNode, int lineNumber) {
        super("routineCallNode", lineNumber);
    }

    public OneLineBodyNode(WhileLoopNode whileLoopNode, int lineNumber) {
        super("whileLoopNode", lineNumber);
    }

    public OneLineBodyNode(ForLoopNode forLoopNode, int lineNumber) {
        super("forLoopNode", lineNumber);
    }

    public OneLineBodyNode(IfStatementNode ifStatementNode, int lineNumber) {
        super("ifStatementNode", lineNumber);
    }

    public OneLineBodyNode(ReturnStatementNode returnStatement, int lineNumber) {
        super("returnStatement", lineNumber);
    }
}
