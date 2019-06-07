package Lexer;

import java.util.List;

public interface Lexer {

   List<Token> generateTokens(String file);
}
