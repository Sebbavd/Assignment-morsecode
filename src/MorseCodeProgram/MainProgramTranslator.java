package MorseCodeProgram;

import java.util.Scanner;

public class MainProgramTranslator {

    public static void main(String[] args) {
        // Skapar bibliotek morsekod - bokstav.
        MorseCodeLibrary library = new MorseCodeLibrary();
        // Skapar translator som använder library.
        Translator translator = new Translator(library);

        Scanner scan = new Scanner(System.in);
        String input;
        // Intro och intruktioner.
        System.out.println("Skriv antingen i text[ Hej ] eller morsekod [ . - ]");
        System.out.println("Endast punkt[ . ] eller bindestreck[ - ]fungerar som morsekod");
        System.out.println("Vill du avsluta så skriver du ( stopp )");
        System.out.println("-------------------------------------------------------------");

        //
        while (true) {
            // Tar bort mellanslag innan/efter.
            input = scan.nextLine().trim();
            // Avslutar programmet om användaren skriver "stopp".
            if (input.equalsIgnoreCase("stopp")) {
                break;
            }
            // Tom input, felhantering.
            if (input.isEmpty()) {
                System.out.println("Du har inte skrivit något");
                continue;
            }
            // Försöker översätta input, catchar fel från logik-klassen.
            try {
                if (input.startsWith(".") || input.startsWith("-")) {
                    // Input börjar med morsetecken, översätt till text.
                    System.out.println(translator.morseToText(input));
                } else {
                    // Annars översätt text till morse.
                    System.out.println(translator.textToMorse(input));
                }
                // Fånger exception som logik-klassen kastar vid fel inmatning.
            }catch (IllegalArgumentException iae){
                System.out.println("Fel: " +iae.getMessage());
            }

        }

    }
}
