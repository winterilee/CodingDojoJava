import java.util.ArrayList;

public class TestPuzzleJava {

    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();

		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);

        char randomLetter = generator.getRandomLetter();
        System.out.println(randomLetter);

        String generatePassword = generator.generatePassword();
        System.out.println(generatePassword);

        ArrayList<String> generatePasswordSet = generator.getNewPasswordSet(5);
        System.out.println(generatePasswordSet);

    }
}