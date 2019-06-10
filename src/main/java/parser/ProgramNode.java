package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class ProgramNode implements Node {
    private List<Statement> children;

    public ProgramNode() {
        children = new ArrayList<>();
    }

    public ProgramNode(List<Statement> children) {
        this.children = children;
    }

    @Override
    public List<Node> getChildren() {
        return  new ArrayList<>(children);
    }

    @Override
    public String getValue() {
        return "PROGRAM NODE";
    }

    @Override
    public Token getToken() {
        return null;
    }


    void addStatement(Statement statement){
        children.add(statement);
    }

}
