/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.assembler;

import anerua.safe.hardware.Memory;
import java.util.HashMap;
import java.util.Map;

/**
 * 17-01-2019
 *
 * @author MARTINS
 */
public class Assembler {

    Map<String, Integer> v_add = new HashMap<>();
    Map<String, Integer> labels = new HashMap<>();
    HashClass hc = new HashClass();

    // Write standard Beta code to memory (memory file)
    public void writeToMem(String[] lines) {
        v_add.entrySet().forEach((Map.Entry<String, Integer> entry) -> {
            Memory.writeInstruction(entry.getValue(), assemble(entry.getKey()));
            System.out.println(entry.getValue());
        });
    }

    // This method assigns addresses to the standard code and to labels
    public void assignAdd(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].contains(":")) {                                                // checks if line contains label
                String label = lines[i].substring(0, lines[i].indexOf(":")).trim();     // extract label name from code
                labels.put(label, i * 4);             // assign address to label
                v_add.put(lines[i].substring(lines[i].indexOf(":") + 1).trim(), i * 4);     // assign address to the real code in line only
            } else {
                v_add.put(lines[i], i * 4);
            }
        }
    }

    // Converts Beta code to binary (denary, in this case) format
    public String assemble(String line) {
        // for the arguments:
        // check if they start with R and if the offset after R is an integer
        // check if it is in the label hash table and then get its value
        int op = hc.op_hash.get(line.substring(0, line.indexOf("(")));

        String args[] = line.substring(line.indexOf("(") + 1, line.indexOf(")")).split(",");
        int ra = Integer.parseInt(args[0].trim().replaceFirst("R", "")),
                rc = Integer.parseInt(args[2].trim().replaceFirst("R", "")),
                rb;
        if (labels.containsKey(args[1])) {
            rb = labels.get(args[1]);
        } else {
            rb = Integer.parseInt(args[1].trim().replaceFirst("R", ""));
        }
        String machine = op + "," + ra + "," + rb + "," + rc;
        return machine;
    }

    // Class entry point 
    public void assemblerMain(String[] lines) {
        assignAdd(lines);
        writeToMem(lines);

    }
}
