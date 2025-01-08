package PlayerImplementation;

import java.util.List;

public class ScoreBoard {
    private List<List<String>> permutations;  // Store the generated permutations

    public ScoreBoard() {
    	List<List<String>> permutations = Generator.generateRandomPermutationsArray();
        this.permutations = permutations;
    }

    public List<List<String>> getScoreBoard() {
        return permutations;
    }

    public void printScoreBoard() {
        System.out.println("ScoreBoard:");
        for (List<String> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}



