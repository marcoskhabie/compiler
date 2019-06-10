package lexer;

public class UnknownState extends LexerState {
    public UnknownState(Context context, String accum) {
        super(context, accum);
    }

    @Override
    Token getToken() {
        return null;
    }

    @Override
    public State next(Character o) {
        return null;
    }
}
