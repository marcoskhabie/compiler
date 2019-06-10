package parser;

import lexer.Token;

import java.util.List;

public class StringNode extends ExpressionNode {
    private String value;
    private Token token;

    public StringNode(String value, Token token) {
        this.value = value;
        this.token = token;
    }

    @Override
    public List<Node> getChildren() {
        return null;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Token getToken() {
        return token;
    }
}
