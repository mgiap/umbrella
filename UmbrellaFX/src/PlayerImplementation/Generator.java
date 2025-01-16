package PlayerImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Generator {

    private static String[] colors = new String[]{"R", "Y", "G", "B"};

    public static List<List<String>> generateRandomPermutationsArray() {
        List<List<String>> permutations = new ArrayList<>();
        List<String> usedColors = new ArrayList<>();

        // Generate 2 random permutations of 2 colors
        for (int i = 0; i < 2; i++) {
            List<String> perm2 = generateRandomPermutation(2);
            permutations.add(perm2);
            usedColors.addAll(perm2);
        }

        // Generate 2 random permutations of 3 colors
        for (int i = 0; i < 2; i++) {
            List<String> perm3 = generateRandomPermutation(3);
            permutations.add(perm3);
            usedColors.addAll(perm3);
        }

        // Ensure all colors are used at least once
        ensureAllColorsUsed(permutations, usedColors);

        // Shuffle the list to randomize the order of permutations
        Collections.shuffle(permutations);

        return permutations;
    }

    private static void ensureAllColorsUsed(List<List<String>> permutations, List<String> usedColors) {
        for (String color : colors) {
            if (!usedColors.contains(color)) {
                // Find a permutation to replace
                List<String> replacementPerm = generateReplacementPermutation(permutations, color);
                if (replacementPerm != null) {
                    permutations.set(permutations.size() - 1, replacementPerm); // Replace last permutation
                }
            }
        }
    }

    private static List<String> generateReplacementPermutation(List<List<String>> permutations, String missingColor) {
        // Find a permutation to replace or adjust that does not already include the missing color
        for (List<String> perm : permutations) {
            if (!perm.contains(missingColor)) {
                // Replace an element in the permutation with the missing color
                List<String> replacement = new ArrayList<>(perm);
                replacement.set(0, missingColor); // Replace the first element for simplicity
                return replacement;
            }
        }
        return null;
    }


    public static List<String> generateRandomPermutation(int size) {
        // List to store the permutation
        List<String> result = new ArrayList<>();

        // Create a list of colors to pick from
        List<String> availableColors = new ArrayList<>();
        Collections.addAll(availableColors, colors);

        // Shuffle the list to randomize the order
        Collections.shuffle(availableColors);

        // Take the first `size` elements from the shuffled list
        for (int i = 0; i < size; i++) {
            result.add(availableColors.get(i));
        }

        // Generate all possible permutations of the selected colors
        List<List<String>> allPermutations = generatePermutations(result);

        // Randomly select one permutation from the list
        return allPermutations.get(new java.util.Random().nextInt(allPermutations.size()));
    }

    private static List<List<String>> generatePermutations(List<String> colors) {
        List<List<String>> result = new ArrayList<>();
        generatePermutationsHelper(colors, 0, result);
        return result;
    }

    private static void generatePermutationsHelper(List<String> colors, int start, List<List<String>> result) {
        if (start == colors.size()) {
            result.add(new ArrayList<>(colors));
            return;
        }
        for (int i = start; i < colors.size(); i++) {
            Collections.swap(colors, start, i);  // Swap to create new permutation
            generatePermutationsHelper(colors, start + 1, result);
            Collections.swap(colors, start, i);  // Swap back to restore original order
        }
    }
}
