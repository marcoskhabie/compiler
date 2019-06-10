package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class TypeNode implements Node {

    Token token;

    public TypeNode(Token token) {
        this.token = token;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>();
    }

    @Override
    public String getValue() {
        return token.getValue();
    }

    @Override
    public Token getToken() {
        return token;
    }
}
