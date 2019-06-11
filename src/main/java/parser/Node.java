package parser;

import lexer.Token;

import java.util.List;

public interface Node extends Visitable {

    List<Node> getChildren();
    String getValue();
    Token getToken();
}
