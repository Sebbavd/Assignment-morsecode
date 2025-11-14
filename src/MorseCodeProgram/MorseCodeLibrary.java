package MorseCodeProgram;

import java.util.HashMap;

public class MorseCodeLibrary {

    // Klass som bara sparar data
    protected HashMap<Character, String> morseLibrary = new HashMap<>();

    public MorseCodeLibrary() {

        morseLibrary.put('A', ".-");
        morseLibrary.put('B', "-...");
        morseLibrary.put('C', "-.-.");
        morseLibrary.put('D', "-..");
        morseLibrary.put('E', ".");
        morseLibrary.put('F', "..-.");
        morseLibrary.put('G', "--.");
        morseLibrary.put('H', "....");
        morseLibrary.put('I', "..");
        morseLibrary.put('J', ".---");
        morseLibrary.put('K', "-.-");
        morseLibrary.put('L', ".-..");
        morseLibrary.put('M', "--");
        morseLibrary.put('N', "-.");
        morseLibrary.put('O', "---");
        morseLibrary.put('P', ".--.");
        morseLibrary.put('Q', "--.-");
        morseLibrary.put('R', ".-.");
        morseLibrary.put('S', "...");
        morseLibrary.put('T', "-");
        morseLibrary.put('U', "..-");
        morseLibrary.put('V', "...-");
        morseLibrary.put('W', ".--");
        morseLibrary.put('X', "-..-");
        morseLibrary.put('Y', "-.--");
        morseLibrary.put('Z', "--..");

    }

}
