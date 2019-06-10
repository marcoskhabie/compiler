package parser;

import Lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class NumberNode extends ExpressionNode {
    String value;
    Token token;

    public NumberNode(String value, Token token) {
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
}
