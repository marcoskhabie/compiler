package Parser;

import Lexer.Token;

import java.util.List;
import java.util.Optional;

public interface Rule {

    String getType();
    Node generateTreeNode();
    Optional<Node> match(List<Token> tokens);
}
