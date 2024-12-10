package PlayerImplementation;

public class TestPatternQuery {
    public static void main(String[] args) {
        Player player = new Player();
        System.out.println("Displaying all patterns in all slots:");
        player.getPatternQuery().displayAllPatterns();
    }
}
