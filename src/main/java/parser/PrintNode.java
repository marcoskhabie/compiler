package parser;

import Lexer.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintNode extends Statement {

    Token token;
    Node leftParenthesis;
    Node expression;
    Node rightParenthesis;


    public PrintNode(Token token, Node leftParenthesis, Node expression, Node rightParenthesis) {
        this.token = token;
        this.leftParenthesis = leftParenthesis;
        this.expression = expression;
        this.rightParenthesis = rightParenthesis;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(Arrays.asList(leftParenthesis, expression, rightParenthesis));
    }

    @Override
    public String getValue() {
        return "print";
    }

    @Override
    public Token getToken() {
        return token;
    }
}
