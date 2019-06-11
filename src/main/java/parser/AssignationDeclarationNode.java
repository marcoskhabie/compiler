package parser;

import lexer.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignationDeclarationNode extends Statement {
    private Node let;
    private Node identifier;
    private Node type;
    private Node expression;
    Token token;


    public AssignationDeclarationNode(Node let, Node identifier, Node type, Node expression, Token token) {
        this.let = let;
        this.identifier = identifier;
        this.type = type;
        this.expression = expression;
        this.token = token;
    }

    @Override
    public List<Node> getChildren() {
        return new ArrayList<>(Arrays.asList(let, identifier, type, expression));
    }

    @Override
    public String getValue() {
        return token.getValue();
    }

    @Override
    public Token getToken() {
        return token;
    }


    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visitAssignationDeclarationNode(this);
    }

    public Node getLet() {
        return let;
    }

    public Node getIdentifier() {
        return identifier;
    }

    public Node getType() {
        return type;
    }

    public Node getExpression() {
        return expression;
    }
}
