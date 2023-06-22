package Lab5;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Text text = new Text("Як твої справи? Чудово! Прочитала сьогодні роман О.С.Пушкіна. І як тобі, а? " +
                "Мені сподобалось... Я теж твори О.С.Пушкіна люблю. ");

        System.out.println("\u001B[32m" + "// Початковий текст:\n" + "\u001B[0m" + text);
        char[] symbols = text.toString().toCharArray();
        ArrayList<String> sentence = new ArrayList();
        ArrayList<String> sentences = new ArrayList();

        // Divide the text into sentences
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == '!' || symbols[i] ==  '?') {
                sentences.add(sentence.toString());
                sentence = new ArrayList();
                sentence.add(Character.toString(symbols[i]));
                sentence.add(Character.toString(symbols[i+1]));
                sentences.add(sentence.toString());
                sentence = new ArrayList();
                i += 2;
            }
            if (symbols[i] == '.') {
                // Three dots (...)
                if (symbols[i+1] == '.') {
                    sentences.add(sentence.toString());
                    sentence = new ArrayList();
                    sentence.add(Character.toString(symbols[i]));
                    sentence.add(Character.toString(symbols[i+1]));
                    sentence.add(Character.toString(symbols[i+2]));
                    sentence.add(Character.toString(symbols[i+3]));
                    sentences.add(sentence.toString());
                    sentence = new ArrayList();
                    i += 3;
                }
                // Initials
                if (Character.isUpperCase(symbols[i-1])) {
                    sentence.add(Character.toString(symbols[i]));
                }
                if (Character.isLowerCase(symbols[i-1])) {
                    sentences.add(sentence.toString());
                    sentence = new ArrayList();
                    sentence.add(Character.toString(symbols[i]));
                    sentence.add(Character.toString(symbols[i+1]));
                    sentences.add(sentence.toString());
                    sentence = new ArrayList();
                    i ++;
                }
            }
            else {
                sentence.add(Character.toString(symbols[i]));
            }
        }

        ArrayList<String> sentences2 = new ArrayList();
        ArrayList<String> textParts = new ArrayList();

        for (int i = 0; i < sentences.size(); i++) {
            sentences2.add(sentences.get(i).replace(", " , "").replaceAll("[\\[\\]]", ""));
            // Divide the sentence into words
            String[] parts = sentences2.get(i).split(" ");
            if (parts.length > 1) {
                String first = parts[0];
                parts[0] = parts[parts.length - 1].replace(". ", "");
                parts[0] = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1);
                parts[parts.length - 1] = first.toLowerCase();
                // Combine words into sentences
                String resultSentence = String.join(" ", parts);
                textParts.add(resultSentence);
            }
            else {
                String resultSentence = String.join(" ", parts);
                textParts.add(resultSentence);
            }
        }
        // Combine sentences into text
        String resultText = String.join(" ", textParts).replace("  ", " ");
        String result = resultText.replace(" .", ".").replace(" !", "!").
                replace(" ?", "?").replace(" ...", "...");

        System.out.println("\u001B[32m" + "// Текст, в кожному реченні якого змінено місцями перше та останнє слово:");
        System.out.println("\u001B[0m" + result);
    }
}
