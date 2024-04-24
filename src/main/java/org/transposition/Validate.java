package org.transposition;

public class Validate {

    static void validate(Integer noteNumber, Key key, Integer transposition) {
        if (noteNumber > 88 || noteNumber < 1) {

            String message = "Note [" + key.getOctave() + "," + key.getNote() + "] " +
                    "plus transposition " + transposition + " " +
                    "falls out of the keyboard range";

            throw new RuntimeException(message);
        }
    }
}
