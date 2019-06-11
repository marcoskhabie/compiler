package interpreter;

public class Literal {

    private Object value;
    private LiteralType type;

    public Literal(Object value, LiteralType type) {
        this.value = value;
        this.type = type;
    }

    public String getStringValue() {
        return value.toString();
    }

    public Double getNumberValue() {
        return new Double(value.toString());
    }

    public LiteralType getType() {
        return type;
    }
}
