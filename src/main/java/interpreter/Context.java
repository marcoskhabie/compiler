package interpreter;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Literal> assignations;
    private Displayer displayer;

    public Context() {
        this.assignations = new HashMap<>();
        this.displayer = new DisplayerImpl();
    }

    public Context(Map<String, Literal> assignations) {
        this.assignations = assignations;
    }

    void addAssignation(String s, Literal l ) {
        assignations.put(s,l);
    }

    boolean variableIsDefined(String s ) {
        return assignations.containsKey(s);
    }

    Literal getValueOfVariable(String key) {
        return assignations.get(key);
    }

    public Map<String, Literal> getAssignations() {
        return assignations;
    }

    public Displayer getDisplayer() {
        return displayer;
    }
}
