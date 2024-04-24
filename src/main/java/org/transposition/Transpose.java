package org.transposition;

import java.util.ArrayList;

import static org.transposition.Validate.validate;

public class Transpose {

    static Key convertNumberToKey(int noteNumber) {
        if (noteNumber == 1) return new Key(-3, 10);
        if (noteNumber == 2) return new Key(-3, 11);
        if (noteNumber == 3) return new Key(-3, 12);

        return new Key(((noteNumber - 3) / 12) - 2, (noteNumber - 3) % 12);
    }

    public static Integer convertKeyToNumber(Key key) {
        return 12 * (key.getOctave() + 2) + 3 + key.getNote();
    }

    public static void transpose(ArrayList<Key> inputKeyboard, Integer transposition, ArrayList<Key> outputKeyboard) {
        for (Key key : inputKeyboard) {
            int noteNumberTransposed = convertKeyToNumber(key) + transposition;
            validate(noteNumberTransposed, key, transposition);
            outputKeyboard.add(convertNumberToKey(noteNumberTransposed));
        }
    }
}
