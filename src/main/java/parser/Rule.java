package parser;

import Lexer.Token;

import java.util.List;
import java.util.Optional;

public interface Rule {

    String getType();
    Node generateTreeNode(List<Node> nodes);
    Optional<Node> match(List<Token> tokens);
}
