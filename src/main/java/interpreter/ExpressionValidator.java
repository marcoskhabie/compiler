package interpreter;

import lexer.Range;
import parser.*;


public class ExpressionValidator implements ExpressionVisitor {

    private Context context;
    private Literal result;

    public ExpressionValidator(Context context) {
        this.context = context;
        this.result = null;

    }

    @Override
    public void visitExpressionComposeNode(ExpressionComposeNode expressionComposeNode) {
        expressionComposeNode.getLeft().accept(this);
        Literal left = this.result;
        expressionComposeNode.getRight().accept(this);
        Literal right = this.result;
        Operator operator = expressionComposeNode.getOperator();
        boolean isOneString = left.getType().equals(LiteralType.STRING) || right.getType().equals(LiteralType.STRING);

        Range columnRange = expressionComposeNode.getToken().getColumnRange();
        Range rowRange = expressionComposeNode.getToken().getRowRange();
        switch (operator) {
            case PLUS:
                if (isOneString) {
                    result = new Literal(left.getStringValue() + right.getStringValue(), LiteralType.STRING);
                } else {
                    result = new Literal(left.getNumberValue() + right.getNumberValue(), LiteralType.NUMBER);
                }

                break;

            case MINUS:
                if (isOneString)
                    throw new InterpreterException("[INTERPRETER ERROR] Invalid operation types at rows: " + rowRange.toString() + "columns: "+ columnRange.toString());
                else result = new Literal(left.getNumberValue() - right.getNumberValue(), LiteralType.NUMBER);

                break;

            case PRODUCT:
                if (isOneString)
                    throw new InterpreterException("[INTERPRETER ERROR] Invalid operation types at: " + rowRange.toString() + "columns: "+ columnRange.toString());
                else result = new Literal(left.getNumberValue() * right.getNumberValue(), LiteralType.NUMBER);

                break;

            case DIVISION:
                if (isOneString)
                    throw new InterpreterException("[INTERPRETER ERROR] Invalid operation types at: " + rowRange.toString() + "columns: "+ columnRange.toString());
                else result = new Literal(left.getNumberValue() / right.getNumberValue(), LiteralType.NUMBER);

                break;

        }
    }

    @Override
    public void visitStringNode(StringNode stringNode) {
        result = new Literal(stringNode.getValue(), LiteralType.STRING);
    }

    @Override
    public void visitNumberNode(NumberNode numberNode) {
        result = new Literal(numberNode.getValue(), LiteralType.NUMBER);
    }

    @Override
    public void visitIdentifierNode(IdentifierNode identifierNode) {
        String value = identifierNode.getValue();
        if (context.variableIsDefined(value)) {
            result = context.getValueOfVariable(value);
        } else {
            throw new InterpreterException("[INTERPRETER ERROR] Variable " + value + " was not declared");
        }
    }

    public Context getContext() {
        return context;
    }

    public Literal getResult() {
        return result;
    }
}
