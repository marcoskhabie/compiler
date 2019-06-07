package Lexer;

public class IdentifierOrReservedWordState extends LexerState {

    public IdentifierOrReservedWordState(Context context, String accum) {
        super(context, accum);
    }

    @Override
    Token getToken() {

        TokenType tokenType;
        switch (accum) {
            case "print":
                tokenType = TokenType.Print;
                break;
            case "let":
                tokenType = TokenType.Let;
                break;
            case "string":
                tokenType = TokenType.StringType;
                break;
            case "number":
                tokenType = TokenType.NumberType;
                break;
            case "boolean":
                tokenType = TokenType.BooleanType;
                break;

            case "true":

            case "false":
                tokenType = TokenType.BooleanLiteral;
                break;

            default:
                tokenType = TokenType.Identifier;
                break;

        }

        return new TokenImpl(context.getColumnRange(), context.getRowRange(), tokenType, accum);
    }


    @Override
    public State next(Character c) {
        if (LexerConstants.END_OF_TOKEN_CHARS.contains(c)) {
            addTokenToResult();
            accum = String.valueOf(c);
            return new SingleCharState(context, accum);
        } else if (String.valueOf(c).matches(LexerConstants.LETTER)) {
            accum += c;
            return this;
        } else return new InitialState(context, accum).next(c);

    }
}
