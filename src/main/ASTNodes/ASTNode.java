public abstract class ASTNode implements Node {
    protected String label;
    protected int lineNumber;

    public ASTNode(String label, int lineNumber) {
        this.label = label;
        this.lineNumber = lineNumber;
    }

    public String getLabel() {
        return label;
    }

    public int getLineNumber() {
        return lineNumber;
    }

}






