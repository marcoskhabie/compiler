package parser;

public interface Visitable {
    void accept(NodeVisitor nodeVisitor);
}
