package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class IdentifierNode extends ExpressionNode{

    private String value;
    Token token;

    public IdentifierNode(String value, Token token) {
        this.value = value;
        this.token = token;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visitIdentifierNode(this);

    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitIdentifierNode(this);

    }
}
