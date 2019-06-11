package parser;

public abstract class ExpressionNode implements Node {
    public abstract void accept(ExpressionVisitor expressionVisitor);
}
