package parser;

public interface ExpressionVisitor {

    void visitExpressionComposeNode(ExpressionComposeNode expressionComposeNode);
    void visitStringNode(StringNode stringNode);
    void visitNumberNode(NumberNode numberNode);
    void visitIdentifierNode(IdentifierNode identifierNode);
}
