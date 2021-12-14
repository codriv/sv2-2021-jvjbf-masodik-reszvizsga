package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        if (word == null) {throw new IllegalArgumentException("It can not be null!");}
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (hasUpperCase(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    private boolean hasUpperCase(String word) {
        for (Character character : word.toCharArray()) {
            if (Character.isUpperCase(character)) {
                return true;
            }
        }
        return false;
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size(); i++) {
            if (isEqualToNext(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean isEqualToNext(int i) {
        for (int j = i + 1; j < words.size(); j++) {
            if (words.get(i).equals(words.get(j))) {
                return true;
            }
        }
        return false;
    }
}