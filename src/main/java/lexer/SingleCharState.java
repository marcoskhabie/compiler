package lexer;

public class SingleCharState extends LexerState {
    public SingleCharState(Context context, String accum) {
        super(context, accum);
    }

    @Override
    public State next(Character o) {
        addTokenToResult();
        return new InitialState(context, accum).next(o);
    }

    @Override
    Token getToken() {
        TokenType tokenType;
        switch (accum) {
            case ";":
                tokenType = TokenType.Semicolon;
                break;
            case ":":
                tokenType = TokenType.Colon;
                break;
            case "\n":
                tokenType = TokenType.Enter;
                break;
            case " ":
                tokenType = TokenType.Space;
                break;
            case ",":
                tokenType = TokenType.Comma;
                break;
            case "(":
                tokenType = TokenType.LeftParenthesis;
                break;
            case ")":
                tokenType = TokenType.RightParenthesis;
                break;
            case "=":
                tokenType = TokenType.EQUAL;
                break;

            default:
                if (LexerConstants.OPERATOR_CHARS.contains(accum.charAt(0))) {
                    tokenType = TokenType.ArithmeticOperation;
                } else tokenType = TokenType.Unknown;
                break;
        }

        return new TokenImpl(context.getColumnRange(), context.getRowRange(), tokenType, this.accum);
    }
}
