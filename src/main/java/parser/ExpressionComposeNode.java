package parser;

import lexer.Token;

import java.util.List;

public class ExpressionComposeNode extends ExpressionNode {
    private ExpressionNode left;
    private ExpressionNode right;
    private Operator operator;
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

    @Override
    public void accept(ExpressionVisitor expressionVisitor) {
        expressionVisitor.visitExpressionComposeNode(this);
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitExpressionComposeNode(this);
    }

    public ExpressionNode getLeft() {
        return left;
    }

    public ExpressionNode getRight() {
        return right;
    }

    public Operator getOperator() {
        return operator;
    }
}
