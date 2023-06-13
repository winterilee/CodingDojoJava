import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randNumArray = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            Random randInt = new Random();
            int sampleInt = randInt.nextInt(20);
            if (randNumArray.contains(sampleInt)) {
                i--;
            }
            else {
                randNumArray.add(sampleInt);
            }
        }
        return randNumArray;
    }

    public char getRandomLetter() {
        ArrayList<Character> randLetterArray = new ArrayList<Character>();
        for (char c = 'a'; c <= 'z'; c++) {
            randLetterArray.add(c);
        }
        Random randIndex = new Random();
        int sampleIndex = randIndex.nextInt(26);
        char randLetter = randLetterArray.get(sampleIndex);
        return randLetter;
    }

    public String generatePassword() {
        String password = "";
        for (int i = 0; i < 8; i++) {
            char sampleChar = getRandomLetter();
            String sampleLetter = String.valueOf(sampleChar);
            password = password.concat(sampleLetter);
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int setNum) {
        ArrayList<String> passwordList = new ArrayList<String>();
        for (int i = 0; i < setNum; i++){
            String sampleString = generatePassword();
            passwordList.add(sampleString);
        }
        return passwordList;
    }

}
