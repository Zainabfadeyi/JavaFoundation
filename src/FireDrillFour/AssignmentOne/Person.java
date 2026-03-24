package src.FireDrillFour.AssignmentOne;



import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Problem> problems;


    public Person(String name){
        this.name = name;
        problems = new ArrayList<>();
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void addProblem(Problem problem){
        problems.add(problem);
    }

    public Problem getProblem(String problemName){
        return problems.stream()
                .filter(p -> p.getName().equals(problemName))
                .findFirst()
                .orElse(null);
    }

    public List<Problem> tellProblems(){
        return problems.stream()
                .filter(p -> !p.isSolved()).toList();
    }
}