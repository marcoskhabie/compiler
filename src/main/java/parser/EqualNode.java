package parser;

import Lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class EqualNode implements Node {

    Token token;
    String value;

    public EqualNode(Token token, String value) {
        this.token = token;
        this.value = value;
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
