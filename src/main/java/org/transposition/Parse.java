package org.transposition;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

public class Parse {

    public static final String RESULT_FILE = "./src/main/resources/result.json";


    // Read data from the input file and add it to an ArrayList of keyboard.
    static ArrayList<Key> readDataFromFile(String fileName) throws IOException, ParseException, URISyntaxException {
        ArrayList<Key> inputKeyboard = new ArrayList<>();

        URL resource = Parse.class.getClassLoader().getResource(fileName);
        assert resource != null;
        String json = Files.readString(Paths.get(resource.toURI()));
        String string = new JSONParser().parse(json).toString();

        for (int i = 0; i < string.length(); i++) {
            if (isDigit(string.charAt(i))) {
                for (int j = i + 1; j < string.length(); j++) {
                    if (isDigit(string.charAt(j))) {
                        int octave = parseInt(valueOf(string.charAt(i)));
                        int note;

                        if (isDigit(string.charAt(j + 1))) {
                            note = Integer.parseInt(String.valueOf(string.charAt(j)) + string.charAt(j + 1));
                            i = j + 2;
                        } else {
                            note = parseInt(valueOf(string.charAt(j)));
                            i = j + 1;
                        }

                        j = string.length();
                        inputKeyboard.add(new Key(octave, note));
                    }
                }
            }
        }

        return inputKeyboard;
    }

    // Write transposed data to result.json file.
    static void writeDataToFile(ArrayList<Key> outputKeyboard) throws IOException {
        StringBuilder output = new StringBuilder("[");

        for (Key key : outputKeyboard)
            output.append("[").append(key.getOctave()).append(",").append(key.getNote()).append("],");

        output.replace(output.length() - 1, output.length(), "]");

        BufferedWriter writer = new BufferedWriter(new FileWriter(RESULT_FILE));
        writer.write(output.toString());
        writer.close();
    }
}
