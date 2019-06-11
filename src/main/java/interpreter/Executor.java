package interpreter;

import lexer.Range;
import lexer.Token;
import parser.*;

public class Executor implements NodeVisitor {

    private ExpressionValidator expressionValidator;
    private Context context;

    public Executor(Context context) {
        this.expressionValidator = new ExpressionValidator(context);
        this.context = context;
    }


    @Override
    public void visitAssignationNode(AssignationNode assignationNode) {
        Node identifier = assignationNode.getIdentifier();
        String value = identifier.getValue();
        if (context.variableIsDefined(value)) {
            assignationNode.getExpression().accept(this);
            Literal result = expressionValidator.getResult();
            context.addAssignation(value, result);
        } else {

            Token token = identifier.getToken();
            Range rowRange = token.getRowRange();
            Range columnRange = token.getColumnRange();
            throw new InterpreterException("[INTERPRETER ERROR] Not defined variable at rows: ("
                    + rowRange.getFirst()
                    + "," + rowRange.getSecond() + ")" +
                    "columns: (" + columnRange.getFirst() + ","
                    + columnRange.getSecond() + ")");
        }
    }

    @Override
    public void visitDeclarationNode(DeclarationNode declarationNode) {
        String value = declarationNode.getIdentifier().getValue();
        if (context.variableIsDefined(value)) {
            throw new InterpreterException("[INTERPRETER ERROR] Already defined variable" + value);

        } else {
            context.addAssignation(value, null);
        }
    }

    @Override
    public void visitAssignationDeclarationNode(AssignationDeclarationNode assignationDeclarationNode) {
        String value = assignationDeclarationNode.getIdentifier().getValue();
        if (context.variableIsDefined(value)) {
            throw new InterpreterException("[INTERPRETER ERROR] Already defined variable" + value);
        } else {
            assignationDeclarationNode.getExpression().accept(this);
            Literal result = expressionValidator.getResult();
            context.addAssignation(value, result);
        }
    }

    @Override
    public void visitPrintNode(PrintNode printNode) {
        printNode.getExpression().accept(this);
        Literal result = expressionValidator.getResult();
        context.getDisplayer().show(result.getStringValue());
    }

    @Override
    public void visitProgram(ProgramNode programNode) {
        programNode.getChildren().forEach(c -> c.accept(this));
    }

    @Override
    public void visitExpressionComposeNode(ExpressionComposeNode expressionComposeNode) {
        expressionComposeNode.accept(expressionValidator);
    }

    @Override
    public void visitStringNode(StringNode stringNode) {
        stringNode.accept(expressionValidator);

    }

    @Override
    public void visitNumberNode(NumberNode numberNode) {
        numberNode.accept(expressionValidator);

    }

    @Override
    public void visitIdentifierNode(IdentifierNode identifierNode) {
        identifierNode.accept(expressionValidator);

    }
}
