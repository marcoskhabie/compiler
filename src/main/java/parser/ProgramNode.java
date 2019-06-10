package parser;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode implements Node {
    List<Statement> children;

    public ProgramNode() {
        children = new ArrayList<Statement>();
    }

    public ProgramNode(List<Statement> children) {
        this.children = children;
    }

    @Override
    public List<Node> getChildren() {
        return  new ArrayList<>(children);
    }


    void addStatement(Statement statement){
        children.add(statement);
    }

}
