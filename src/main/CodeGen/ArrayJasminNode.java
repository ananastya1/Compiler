import java.util.ArrayList;
import java.util.List;

public class ArrayJasminNode {
    String identifier;
    int dimension;
    List<Integer> sizes = new ArrayList<>();
    String type;

    public ArrayJasminNode(String identifier, int dimension, String type) {
        this.identifier = identifier;
        this.dimension = dimension;
        this.type = type;
    }

    public ArrayJasminNode(String identifier) {
        this.identifier = identifier;

    }
}
