package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
//        if (word == null) {throw new IllegalArgumentException("It should be valid word");}
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (hasUpperCase(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    // hasUpperCase works only with english alphabet!!

    private boolean hasUpperCase(String word) {
        for (Character character: word.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}