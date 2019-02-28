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
public class Control {

    public static int ALUFN(int op) {
        switch (op) {
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 2;
            case 7:
                return 3;
            case 8:
                return 3;
            case 9:
                return 4;
            case 10:
                return 4;
            case 11:
                return 5;
            case 12:
                return 5;
            case 13:
                return 6;
            case 14:
                return 6;
            case 16:
                return 1;
            case 17:
                return 7;
            case 18:
                return 8;
            case 19:
                return 8;
            case 20:
                return 9;
            case 21:
                return 9;
            case 22:
                return 10;
            case 23:
                return 10;
            case 24:
                return 11;
            case 25:
                return 11;
            case 26:
                return 12;
            case 27:
                return 12;
            case 28:
                return 1;
            case 29:
                return 13;
            case 30:
                return 13;
            case 31:
                return 14;
            case 32:
                return 14;
            default:
                return -32;     //error
        }
    }

    public static int BSEL(int op) {
        switch (op) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 0;
            case 4:
                return 1;
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 0;
            case 10:
                return 1;
            case 11:
                return 0;
            case 12:
                return 1;
            case 13:
                return 0;
            case 14:
                return 1;
            case 16:
                return 1;
            case 18:
                return 0;
            case 19:
                return 1;
            case 20:
                return 0;
            case 21:
                return 1;
            case 22:
                return 0;
            case 23:
                return 1;
            case 24:
                return 0;
            case 25:
                return 1;
            case 26:
                return 0;
            case 27:
                return 1;
            case 28:
                return 1;
            case 29:
                return 0;
            case 30:
                return 1;
            case 31:
                return 0;
            case 32:
                return 1;
            default:
                return -32;     //error
        }
    }

    public static int PCSEL(int op, boolean z) {
        switch (op) {
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 0;
            case 4:
                return 0;
            case 5:
                return toInt(z);
            case 6:
                return toInt(!z);
            case 7:
                return 0;
            case 8:
                return 0;
            case 9:
                return 0;
            case 10:
                return 0;
            case 11:
                return 0;
            case 12:
                return 0;
            case 13:
                return 0;
            case 14:
                return 0;
            case 15:
                return 2;
            case 16:
                return 0;
            case 17:
                return 0;
            case 18:
                return 0;
            case 19:
                return 0;
            case 20:
                return 0;
            case 21:
                return 0;
            case 22:
                return 0;
            case 23:
                return 0;
            case 24:
                return 0;
            case 25:
                return 0;
            case 26:
                return 0;
            case 27:
                return 0;
            case 28:
                return 0;
            case 29:
                return 0;
            case 30:
                return 0;
            case 31:
                return 0;
            case 32:
                return 0;
            default:
                return -32;     //error
        }
    }

    public static int RA2SEL(int op) {
        switch (op) {
            case 1:
                return 0;
            case 3:
                return 0;
            case 7:
                return 0;
            case 9:
                return 0;
            case 11:
                return 0;
            case 13:
                return 0;
            case 18:
                return 0;
            case 20:
                return 0;
            case 22:
                return 0;
            case 24:
                return 0;
            case 26:
                return 0;
            case 28:
                return 1;
            case 29:
                return 0;
            case 31:
                return 0;
            default:
                return -32;     //error
        }
    }

    public static int WDSEL(int op) {
        switch (op) {
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 1;
            case 4:
                return 1;
            case 5:
                return 0;
            case 6:
                return 0;
            case 7:
                return 1;
            case 8:
                return 1;
            case 9:
                return 1;
            case 10:
                return 1;
            case 11:
                return 1;
            case 12:
                return 1;
            case 13:
                return 1;
            case 14:
                return 1;
            case 15:
                return 0;
            case 16:
                return 2;
            case 17:
                return 2;
            case 18:
                return 1;
            case 19:
                return 1;
            case 20:
                return 1;
            case 21:
                return 1;
            case 22:
                return 1;
            case 23:
                return 1;
            case 24:
                return 1;
            case 25:
                return 1;
            case 26:
                return 1;
            case 27:
                return 1;
            case 29:
                return 1;
            case 30:
                return 1;
            case 31:
                return 1;
            case 32:
                return 1;
            default:
                return -32;     //error
        }
    }

    public static int WERF(int op) {
        switch (op) {
            case 28:
                return 0;
            default:
                return 1;
        }
    }

    public static int WR(int op) {
        switch (op) {
            case 28:
                return 1;
            default:
                return 0;
        }
    }

    public static int toInt(boolean Z) {
        if (Z == true) {
            return 1;
        } else {
            return 0;
        }
    }

}
