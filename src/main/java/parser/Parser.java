package parser;

import lexer.Token;

import java.util.List;

public interface Parser {

    Node parse(String s);

    Node generateTree(List<Token> tokens);

}
