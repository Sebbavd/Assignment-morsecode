package MorseCodeProgram;

import java.util.HashMap;

public class Translator {
    // Omvänd HashMap för Morse - bokstav.
    private HashMap<String, Character> reverseLibrary = new HashMap<>();
    private MorseCodeLibrary library;

    // Konstruktor tar in MorseCodeLibrary och fyller reverseLibrary.
    public Translator(MorseCodeLibrary library) {
        this.library = library;

        // Loopar igenom alla bokstäver i biblioteket och vänder på key och value.
        for (Character letter : library.morseLibrary.keySet()) {
            String morse = library.morseLibrary.get(letter);
            reverseLibrary.put(morse, letter);
        }
    }
    // Översätter text till morsekod.
    public String textToMorse(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toUpperCase(text.charAt(i));

            String morse = library.morseLibrary.get(c);
            if (morse == null) {
                // morse = "?"; Detta va mitt första val, men tycker exceptions bättre
                throw new IllegalArgumentException("Ogiltigt tecken: "+c+" ,endast använda bokstäver");
            }
            result += morse + " "; // Lägger till mellanslag.
        }
        return result.trim(); // Tar bort sista mellanslag.
    }
    // Översätter morsekod till text.
    public String morseToText(String morse) {
        String result = "";

        // Lägger till mellanslag mellan morsekoderna.
        String[] mCode = morse.split(" ");
        for (int i = 0; i < mCode.length; i++) {
            String code = mCode[i];
            Character letter = reverseLibrary.get(code);

            if (letter == null) {
                // result += "?"; Detta va mitt första val.
                // Kastar exception om morsekod inte finns.
                throw new IllegalArgumentException("Ogiltig morsekod: "+code+" ,finns ej");
            } else {
                // Lägger till bokstav.
                result += letter;
            }
        }
        return result;
    }
}
