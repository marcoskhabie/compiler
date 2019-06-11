package parser;

import lexer.Token;

import java.util.List;

public class DeclarationNode extends Statement {

    private Node let;
    private Node identifier;
    private Node type;
    Token token;

    public DeclarationNode(Node let, Node identifier, Node type, Token token) {
        this.let = let;
        this.identifier = identifier;
        this.type = type;
        this.token = token;
    }

    @Override
    public List<Node> getChildren() {
        return null;
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
        nodeVisitor.visitDeclarationNode(this);
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
}
