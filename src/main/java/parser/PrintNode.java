package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintNode extends Statement {

    Token token;
    private Node leftParenthesis;
    private Node expression;
    private Node rightParenthesis;


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

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitPrintNode(this);
    }

    public Node getLeftParenthesis() {
        return leftParenthesis;
    }

    public Node getExpression() {
        return expression;
    }

    public Node getRightParenthesis() {
        return rightParenthesis;
    }
}
