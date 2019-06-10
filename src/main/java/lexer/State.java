package lexer;

public interface State {

     State next(Character o);

    void addTokenToResult();

}
