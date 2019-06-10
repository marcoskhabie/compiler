package lexer;

import java.util.List;

public class LexerImpl implements Lexer {
    private Context context;
    private State currentState;


    public LexerImpl(Context context, State currentState) {
        this.context = context;
        this.currentState = currentState;
    }

    public LexerImpl(Context context) {
        this.context = context;
        this.currentState = new InitialState(context, "");
    }

    public LexerImpl() {
        this.context = new ContextImpl(0, 0, 0, 0);
        this.currentState = new InitialState(context, "");

    }

    @Override
    public List<Token> generateTokens(String file) {
        for (int i = 0; i < file.length(); i++) {
            char actual = file.charAt(i);
            this.currentState = currentState.next(actual);
            if (actual == '\n') {
                context.nextRow();
            } else {
                context.nextColumn();
            }
        }
        this.currentState.addTokenToResult();

        return context.getResult();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
