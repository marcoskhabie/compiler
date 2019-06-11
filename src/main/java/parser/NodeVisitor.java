package parser;

public interface NodeVisitor extends ExpressionVisitor{

    void visitAssignationNode(AssignationNode assignationNode);
    void visitDeclarationNode(DeclarationNode declarationNode);
    void visitAssignationDeclarationNode(AssignationDeclarationNode assignationDeclarationNode);
    void visitPrintNode(PrintNode printNode);
    void visitProgram(ProgramNode programNode);



}
