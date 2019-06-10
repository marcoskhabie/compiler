package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignationNode extends Statement{

    Node identifier;
    Node expresion;

    public AssignationNode(Node identifier, Node expresion) {
        this.identifier = identifier;
        this.expresion = expresion;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(Arrays.asList(identifier,expresion));
    }

}
