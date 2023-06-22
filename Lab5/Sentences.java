package Lab5;

public class Sentences {
    public int length;
    private Words[] words;

    public Sentences(String sentencesString) {
        String[] wordsString = sentencesString.split(" ");
        words = new Words[wordsString.length];
        length = wordsString.length;
        for (int i = 0; i < wordsString.length; i++) {
            words[i] = new Words(wordsString[i]);
        }
    }

    public String toString() {
        StringBuilder sentencesString = new StringBuilder();
        //цикл для накопичення елентів через індекс
        for (int i = 0; i < words.length; i++) {
            sentencesString.append(i != 0 && words[i] != null ? " " : "").append(words[i].toString());
        }
        return sentencesString.toString();
    }
}
