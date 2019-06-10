package parser;

import lexer.Token;

import java.util.List;

public class ExpressionComposeNode extends ExpressionNode {
    ExpressionNode left;
    ExpressionNode right;
    Operator operator;
    Token token;

    public ExpressionComposeNode(ExpressionNode left, ExpressionNode right, Operator operator, Token token) {
        this.left = left;
        this.right = right;
        this.operator = operator;
        this.token = token;
    }



    @Override
    public List<Node> getChildren() {
        return null;
    }

    @Override
    public String getValue() {
        return operator.name();
    }

    @Override
    public Token getToken() {
        return token;
    }
}
