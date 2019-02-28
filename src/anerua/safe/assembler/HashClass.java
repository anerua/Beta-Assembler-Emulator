/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.assembler;

import java.util.HashMap;
import java.util.Map;

/**
 * 17-01-2019
 *
 * @author MARTINS
 */
public class HashClass {

    Map<String, Integer> op_hash = new HashMap<>();

    public HashClass() {
        op_hash.put("ADD", 1);
        op_hash.put("ADDC", 2);
        op_hash.put("AND", 3);
        op_hash.put("ANDC", 4);
        op_hash.put("BEQ", 5);
        op_hash.put("BF", 5);
        op_hash.put("BNE", 6);
        op_hash.put("BT", 6);
        op_hash.put("CMPEQ", 7);
        op_hash.put("CMPEQC", 8);
        op_hash.put("CMPLE", 9);
        op_hash.put("CMPLEC", 10);
        op_hash.put("CMPLT", 11);
        op_hash.put("CMPLTC", 12);
        op_hash.put("DIV", 13);
        op_hash.put("DIVC", 14);
        op_hash.put("JMP", 15);
        op_hash.put("LD", 16);
        op_hash.put("LDR", 17);
        op_hash.put("MUL", 18);
        op_hash.put("MULC", 19);
        op_hash.put("OR", 20);
        op_hash.put("ORC", 21);
        op_hash.put("SHL", 22);
        op_hash.put("SHLC", 23);
        op_hash.put("SHR", 24);
        op_hash.put("SHRC", 25);
        op_hash.put("SRA", 26);
        op_hash.put("SRAC", 27);
        op_hash.put("ST", 28);
        op_hash.put("SUB", 29);
        op_hash.put("SUBC", 30);
        op_hash.put("XOR", 31);
        op_hash.put("XORC", 32);
    }
}
