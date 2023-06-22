package Lab5;

public class Words extends SentenceElement {
    private Letters[] letters;
    public Words(String wordsString) {
        char[] lettersChars = wordsString.toCharArray();
        letters = new Letters[lettersChars.length];
        for (int i = 0; i < lettersChars.length; i++) {
            letters[i] = new Letters(lettersChars[i]);
        }
    }
    public String toString(){
        StringBuilder wordsString = new StringBuilder();
        for (Letters letters : letters) {
            wordsString.append(letters.toString());
        }
        return wordsString.toString();
    }
}
