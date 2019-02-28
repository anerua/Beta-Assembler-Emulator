/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.hardware;

/**
 * 17-11-2018
 *
 * @author MARTINS
 */
public class ALU {

    public static int logic(int A, int B, int alufn) {
        switch (alufn) {
            case 1:
                return A + B;
            case 2:
                return A & B;
            case 3:
                if (A == B) {
                    return 1;
                } else {
                    return 0;
                }
            case 4:
                if (A <= B) {
                    return 1;
                } else {
                    return 0;
                }
            case 5:
                if (A < B) {
                    return 1;
                } else {
                    return 0;
                }
            case 6:
                return A / B;
            case 7:
                return A;
            case 8:
                return A * B;
            case 9:
                return A | B;
            case 10:
            // shift left
            case 11:
            // shift right
            case 12:
            // shift right arithmetically
            case 13:
                return A - B;
            case 14:
                return A ^ B;
            default:
                return -32;
        }
    }

}
