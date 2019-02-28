/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.software;

/**
 *
 * @author MARTINS
 */
// Consider moving this class to the assembler package as it may be easier to program it from there
public class MachineFcns {

    public static int opcode(String command) {
        command = command.trim();

        switch (command) {
            case "ADD":
                return 32;
            case "ADDC":
                return 48;
            case "AND":
                return 40;
            case "ANDC":
                return 56;
            case "BEQ":
                return 29;
            case "BF":
                return 29;
            case "BNE":
                return 30;
            case "BT":
                return 30;
            case "CMPEQ":
                return 36;
            case "CMPEQC":
                return 52;
            case "CMPLE":
                return 38;
            case "CMPLEC":
                return 54;
            case "CMPLT":
                return 37;
            case "CMPLTC":
                return 53;
            case "DIV":
                return 35;
            case "DIVC":
                return 51;
            case "JMP":
                return 27;
            case "LD":
                return 24;
            case "LDR":
                return 31;
            case "MUL":
                return 34;
            case "MULC":
                return 50;
            case "OR":
                return 41;
            case "ORC":
                return 57;
            case "SHL":
                return 44;
            case "SHLC":
                return 60;
            case "SHR":
                return 45;
            case "SHRC":
                return 61;
            case "SRA":
                return 46;
            case "SRAC":
                return 62;
            case "ST":
                return 25;
            case "SUB":
                return 33;
            case "SUBC":
                return 49;
            case "XOR":
                return 42;
            case "XORC":
                return 58;
            default:
                return -32;
        }
    }

    public static String formatLen(int length, int data) {
        String bin = Integer.toBinaryString(data);
        int len = bin.length();
        int offset = length - len;
        int sign = Integer.signum(data) < 0 ? 1 : 0;
        String zeros = "";
        for (int i = 0; i < offset; i++) {
            zeros += sign;
        }
        String formatted = zeros + bin;
        return formatted.substring(formatted.length() - length);
    }

    public static String format1(String operation, int Ra, int Rb, int Rc) {
        int op = opcode(operation);
        String opcode = formatLen(6, op);
        String RC = formatLen(5, Rc);
        String RA = formatLen(5, Ra);
        String RB = formatLen(5, Rb);
        return opcode + " " + RC + " " + RA + " " + RB + " " + "00000000000";
    }

    public static String format2(String operation, int Ra, int literal, int Rc) {
        int op = opcode(operation);
        String opcode = formatLen(6, op);
        String RC = formatLen(5, Rc);
        String RA = formatLen(5, Ra);
        String lit = formatLen(16, literal);
        return opcode + " " + RC + " " + RA + " " + lit;
    }

}
