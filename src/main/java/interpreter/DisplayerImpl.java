package interpreter;

public class DisplayerImpl implements Displayer {
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
