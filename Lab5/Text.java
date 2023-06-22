package Lab5;

public class Text {
    private Sentences[] sentences;

    public Text(String textString) {
        String[] sentencesString = textString.split("(\\\\. )|(\\\\? )|(\\\\! )|(\\\\.\\\\.\\\\. )");
        sentences = new Sentences[sentencesString.length];
        for (int i = 0; i < sentencesString.length; i++) {
            sentences[i] = new Sentences(sentencesString[i]);
        }
    }

    public String toString() {
        StringBuilder textString = new StringBuilder();
        for (Sentences sentence : sentences) {
            textString.append(sentence.toString()).append(" ");
        }
        return textString.toString();
    }
}

