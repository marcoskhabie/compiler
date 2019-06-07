package Lexer;


public interface Token {

    Range getColumnRange();
    Range getRowRange();
    TokenType getTokenType();
    String getValue();

}
