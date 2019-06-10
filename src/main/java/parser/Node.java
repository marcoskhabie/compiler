package parser;

import Lexer.Token;

import java.util.List;

public interface Node {

    List<Node> getChildren();
    String getValue();
    Token getToken();
}
