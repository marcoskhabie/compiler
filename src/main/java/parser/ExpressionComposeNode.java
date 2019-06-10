package parser;

import Lexer.TokenType;

import java.util.List;
import java.util.Optional;

public class ExpressionComposeNode extends ExpressionNode {
    ExpressionNode left;
    ExpressionNode right;
    Operator operator;
    public ExpressionComposeNode(Node left, TokenType tokenType,Node right) {

    }

    public ExpressionComposeNode(ExpressionNode left, ExpressionNode right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public List<Node> getChildren() {
        return null;
    }
}
