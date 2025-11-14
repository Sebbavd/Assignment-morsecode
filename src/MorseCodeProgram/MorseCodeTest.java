package MorseCodeProgram;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MorseCodeTest {

    @Test // Testar logik-klassen översätter korrekt.
    public void testOfCorrectCodeConverter() {
        MorseCodeLibrary library = new MorseCodeLibrary();
        Translator translator = new Translator(library);

        assertEquals(".-", translator.textToMorse("A"));
        assertEquals("A", translator.morseToText(".-"));
    }

    @Test // Testar inkorrekt inmatning.
    public void testOfIncorrectCodeConverter() {
        MorseCodeLibrary library = new MorseCodeLibrary();
        Translator translator = new Translator(library);

        assertThrows(IllegalArgumentException.class, () -> translator.textToMorse("Å"));
        assertThrows(IllegalArgumentException.class, () -> translator.morseToText("H"));
        //assertEquals("?", translator.textToMorse("Å")); Dessa använde jag första när jag började min TDD men ändrade efter
        //assertEquals("?", translator.morseToText("H")); med exceptions, tyckte det blev bättre och smidigare med felhanteringarna
    }

    @Test // Testar hur klassen hanterar fel inmatning i en mening/ord.
    public void testOfWrongSentence() {
        MorseCodeLibrary library = new MorseCodeLibrary();
        Translator translator = new Translator(library);

        assertThrows(IllegalArgumentException.class, () -> translator.textToMorse("AB%T"));
        assertThrows(IllegalArgumentException.class, () -> translator.morseToText("... . 8 ."));
        //assertEquals(".- -... ? -", translator.textToMorse("AB%T"));
        //assertEquals("SE?E", translator.morseToText("... . 8 ."));
    }
    @Test // Testar att all inmatning ändras till versaler.
    public void testOfUpperCase(){
        MorseCodeLibrary library = new MorseCodeLibrary();
        Translator translator = new Translator(library);

        assertEquals(".... . .--- ... .- -.", translator.textToMorse("HeJsaN"));
    }

    @Test // Visar vad som kommer att visas i terminalen om inget fält fylls i.
    public void emptyInput(){
        MorseCodeLibrary library = new MorseCodeLibrary();
        Translator translator = new Translator(library);

        String input = "";
        assertEquals("", translator.textToMorse(input));
    }

    @Test // Testar vad som händer om mellanslag glöms.
    public void testOfNoSpaceBetweenMorseCode(){
        MorseCodeLibrary library = new MorseCodeLibrary();
        Translator translator = new Translator(library);

        assertThrows(IllegalArgumentException.class, () -> translator.morseToText(".-.-."));
        assertThrows(IllegalArgumentException.class, () -> translator.morseToText(".- .-..-"));
        //assertEquals("?", translator.morseToText(".-.-."));
        //assertEquals("A?", translator.morseToText(".- .-..-"));
    }

    @Test // Testar mellanslag innan och efter.
    public void testOfSpaceBeforeAndAfterRemoves(){
        MorseCodeLibrary library = new MorseCodeLibrary();
        Translator translator = new Translator(library);

        String input = "  Eva  ".trim();
        assertEquals(". ...- .-", translator.textToMorse(input));
    }
}
