package org.transposition;

import java.util.Scanner;

import static java.lang.System.out;

public class Scan {

    static String enterFileName() {
        out.print("\nEnter file name for input data: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    static Integer setTransposition() {
        out.print("\nEnter number of semitones to transpose: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
