package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignationNode extends Statement{

    private Node identifier;
    private Node expresion;
    Token token;


    public AssignationNode(Node identifier, Node expresion, Token token) {
        this.identifier = identifier;
        this.expresion = expresion;
        this.token = token;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(Arrays.asList(identifier,expresion));
    }

    @Override
    public String getValue() {
        return "=";
    }

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitAssignationNode(this);
    }

    public Node getIdentifier() {
        return identifier;
    }

    public Node getExpression() {
        return expresion;
    }
}
