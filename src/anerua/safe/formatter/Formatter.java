/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.formatter;

/**
 * 15-01-2019
 *
 * @author MARTINS
 */
public class Formatter {

    // Entry point for the class
    public String[] toStandard(String source) {
        String[] lines = source.trim().split("\n"); // remove whitespace from the start and end of source code
        return formatLabels(removeSpaces(lines));
    }

    public String[] removeSpaces(String[] lines) {
        int i = 0;
        for (String line : lines) {
            line = line.trim();                     // remove whitespace from each line
            if (line.equals("")) {
                ++i;                                // counts number of empty lines
            }
        }
        String[] new_lines = new String[lines.length - i];
        int j = 0;
        for (String line : lines) {
            if (!line.equals("")) {                  // checks if line is non-empty
                new_lines[j] = line;                // store all non-empty lines in a new array
                ++j;
            }
        }
        return new_lines;
    }

    // This method ensures labels and the code they point to are on the same line
    public String[] formatLabels(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains(":")) {                        // checks if line contains a label
                int pose = lines[i].indexOf(":");               // gets the index of the label separator in the code line
                if (lines[i].substring(pose + 1).equals("")) {   // checks if label and code it points to are on the same line
                    lines[i] += " " + lines[i + 1];             // joins the code on the next line to the label on the current line
                    lines[i] = "";                              // deletes already joined code from the next line
                }
            }
        }
        return removeSpaces(lines);                   // remove empty lines occupied by code that have been meshed with their labels
    }

    /* Write method to format comments */
}
