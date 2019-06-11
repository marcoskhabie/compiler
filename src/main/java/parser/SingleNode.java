package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.List;

public class SingleNode implements Node {

    Token token;
    private String value;

    public SingleNode(Token token, String value) {
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

    @Override
    public void accept(NodeVisitor nodeVisitor) {

    }
}
