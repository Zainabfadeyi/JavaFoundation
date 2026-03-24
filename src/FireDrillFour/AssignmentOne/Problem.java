package src.FireDrillFour.AssignmentOne;

public class Problem {
    private String name;
    private ProblemType type;
    private boolean isSolved;

    public Problem(String name, ProblemType type) {
        this.name = name;
        this.type = type;
        this.isSolved = false;
    }

    public void solve() {
        this.isSolved = true;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return name + " (" + type + ") - " + (isSolved ? "Solved" : "Unsolved");
    }
}