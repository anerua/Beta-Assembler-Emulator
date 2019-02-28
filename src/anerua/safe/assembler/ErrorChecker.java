/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.assembler;

/**
 * 17-01-2019
 *
 * @author MARTINS
 */
public class ErrorChecker {

    HashClass hc = new HashClass();

    // Method to check for incorrect opcode in source code
    public String[] checkOp(String[] lines) {
        String[] reply = new String[2];
        for (String line : lines) {
            int start, end = line.indexOf("(");                     // end of the substring is the character before the first open parenthesis
            start = (line.contains(":")) ? (line.indexOf(":") + 1) : 0;   // start of substring depends on whether the line contains a label or not
            String op = line.substring(start, end - 1).trim();
            if (!hc.op_hash.containsKey(op)) {
                reply[0] = "Error";
                reply[1] = line;
                break;
            }
        }
        return reply;
    }
}
