package org.transposition;

public class Key {

    private final Integer octave;

    private final Integer note;


    public Key(Integer octave, Integer note) {
        this.octave = octave;
        this.note = note;
    }

    public Integer getOctave() {
        return octave;
    }

    public Integer getNote() {
        return note;
    }
}
