package Lexer;

public interface State {

     State next(Character o);

    void addTokenToResult();

}
