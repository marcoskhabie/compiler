package Parser;

import Lexer.Token;

import java.util.List;

public interface Parser {

    Node GenerateTree(List<Token> tokens);

}
