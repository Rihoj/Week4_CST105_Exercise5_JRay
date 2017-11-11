/** Program: JumpText
 * File: JumbleText.java
 * Summary: Reads data from a file and jumbles the text.
 * Author: James Ray
 * Date: November 11, 2017
 */

import java.io.BufferedReader;
import java.io.FileReader;

public class JumbleText {

    //The text from the file.
    private static String fileText = "";
    //The number of rows to accept into the 2-D array
    private static final int ROWS = 20;
    //Number of columns to accept into the 2-D array.
    private static final int COLS = 45;
    //Character to fill into the array for empty spots.
    private static final char FILLER = '@';
    //Array of characters from the text file. Filled with FILLER when the text file does not have enough characters.
    private static final char[][] CHAR_ARRAY = new char[ROWS][COLS];
    //The relative path the file.
    private static final String FILE_LOCATION = "resources/jumble.txt";

    /**
     * Grab the file and add each line to String fileText.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Beginging to parse: " + FILE_LOCATION);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_LOCATION))) {
            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                if (readLine.trim().isEmpty()) {
                    continue;
                }
                fileText += readLine.trim();
            }
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
            System.exit(0);
        }
        LoadArray();
        outputJumble();
    }

    /**
     * Add each character to 2-D array.
     */
    private static void LoadArray() {
        int count = 0;
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (fileText.length() > count) {
                    CHAR_ARRAY[row][col] = fileText.charAt(count);
                    count++;
                } else {
                    CHAR_ARRAY[row][col] = FILLER;
                }
            }
        }
    }

    /**
     * Walk through array using columns first. Output the text to System.out
     */
    private static void outputJumble() {
        String outputText = new String();
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row < ROWS; row++) {
                outputText += CHAR_ARRAY[row][col];
            }
        }
        System.out.println(outputText);
    }

}
