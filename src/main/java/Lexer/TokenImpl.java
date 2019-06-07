package Lexer;

public class TokenImpl implements Token {


    private Range columnRange;
    private Range rowRange;
    private TokenType tokenType;
    private String value;

    public TokenImpl(Range columnRange, Range rowRange, TokenType tokenType, String value) {
        this.columnRange = columnRange;
        this.rowRange = rowRange;
        this.tokenType = tokenType;
        this.value = value;
    }

    @Override
    public Range getColumnRange() {
        return this.columnRange;
    }

    @Override
    public Range getRowRange() {
        return this.rowRange;
    }

    @Override
    public TokenType getTokenType() {
        return this.tokenType;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object other){
        TokenImpl other1 = (TokenImpl) other;
        return other1.columnRange.equals(columnRange) && other1.rowRange.equals(rowRange) && other1.tokenType.equals(tokenType) && other1.value.equals(value);
    }
}
