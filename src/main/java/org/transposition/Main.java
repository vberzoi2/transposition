package org.transposition;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static org.transposition.Log.finalMessage;
import static org.transposition.Parse.readDataFromFile;
import static org.transposition.Parse.writeDataToFile;
import static org.transposition.Scan.enterFileName;
import static org.transposition.Scan.setTransposition;
import static org.transposition.Transpose.transpose;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, ParseException {
        ArrayList<Key> inputKeyboard = readDataFromFile(enterFileName());
        ArrayList<Key> outputKeyboard = new ArrayList<>();

        transpose(inputKeyboard, setTransposition(), outputKeyboard);

        writeDataToFile(outputKeyboard);

        finalMessage();
    }
}