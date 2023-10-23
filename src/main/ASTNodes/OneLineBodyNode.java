public class OneLineBodyNode extends ASTNode{
    private SimpleDeclarationNode simpleDeclaration = null;
    private AssignmentNode assignmentNode = null;
    private RoutineCallNode routineCallNode = null;
    private WhileLoopNode whileLoopNode = null;
    private ForLoopNode forLoopNode = null;
    private IfStatementNode ifStatementNode = null;
    private ReturnStatementNode returnStatement = null;


    public OneLineBodyNode(SimpleDeclarationNode simpleDeclaration, int lineNumber) {
        super("simpleDeclaration", lineNumber);
        this.simpleDeclaration = simpleDeclaration;
    }

    public OneLineBodyNode(AssignmentNode assignmentNode, int lineNumber) {
        super("assignmentNode", lineNumber);
        this.assignmentNode = assignmentNode;
    }

    public OneLineBodyNode(RoutineCallNode routineCallNode, int lineNumber) {
        super("routineCallNode", lineNumber);
        this.routineCallNode = routineCallNode;
    }

    public OneLineBodyNode(WhileLoopNode whileLoopNode, int lineNumber) {
        super("whileLoopNode", lineNumber);
        this.whileLoopNode = whileLoopNode;
    }

    public OneLineBodyNode(ForLoopNode forLoopNode, int lineNumber) {
        super("forLoopNode", lineNumber);
        this.forLoopNode = forLoopNode;
    }

    public OneLineBodyNode(IfStatementNode ifStatementNode, int lineNumber) {
        super("ifStatementNode", lineNumber);
        this.ifStatementNode = ifStatementNode;
    }

    public OneLineBodyNode(ReturnStatementNode returnStatement, int lineNumber) {
        super("returnStatement", lineNumber);
        this.returnStatement = returnStatement;
    }

    public ASTNode getElement(){
        if (this.simpleDeclaration != null) {
            return simpleDeclaration;

        } else if (this.assignmentNode != null){
            return this.assignmentNode;

        } else if (this.routineCallNode != null){
            return this.routineCallNode;

        }else if (this.whileLoopNode != null){
            return this.whileLoopNode;

        }else if (this.forLoopNode != null){
            return this.forLoopNode;

        }else if (this.ifStatementNode != null){
            return this.ifStatementNode;

        }

        return this.returnStatement;
    }

    @Override
    public void printNode(int depth) {

    }
}
