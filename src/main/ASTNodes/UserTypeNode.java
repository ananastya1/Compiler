public class UserTypeNode extends TypeNode {

    public UserTypeNode(int lineNumber, Type type) {
        super("UserType", lineNumber, type);
    }

    public UserTypeNode(String label, int lineNumber, Type type) {
        super(label, lineNumber, type);
    }
}
