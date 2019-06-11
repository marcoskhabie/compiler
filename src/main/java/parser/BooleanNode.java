package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class BooleanNode extends ExpressionNode{
    String value;
    Token token;

    public BooleanNode(String value, Token token) {
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

    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {

    }
}
