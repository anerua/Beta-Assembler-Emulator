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
public class Registers {

    Reg R1 = new Reg(), R2 = new Reg(), R3 = new Reg(), R4 = new Reg(), R5 = new Reg(), R6 = new Reg(), R7 = new Reg(), R8 = new Reg(), R9 = new Reg(), R10 = new Reg(),
            R11 = new Reg(), R12 = new Reg(), R13 = new Reg(), R14 = new Reg(), R15 = new Reg(), R16 = new Reg(), R17 = new Reg(), R18 = new Reg(), R19 = new Reg(), R20 = new Reg(),
            R21 = new Reg(), R22 = new Reg(), R23 = new Reg(), R24 = new Reg(), R25 = new Reg(), R26 = new Reg(),
            R0 = new Reg(), R27 = new Reg(), R28 = new Reg(), R29 = new Reg(), R30 = new Reg(), R31 = new Reg();

    // Array containing list of registers available in the program. Is this needed?
    public Reg[] registers = {R0, R1, R2, R3, R4, R5, R6, R7, R8, R9, R10, R11, R12, R13, R14, R15, R16, R17, R18, R19, R20, R21, R22, R23, R24, R25, R26, R27, R28, R29, R30, R31};

    public Registers() {
        R0.address = 0;
        R0.content = 0;
        R0.bin = "00000";
        R1.address = 1;
        R1.content = 0;
        R1.bin = "00001";
        R2.address = 2;
        R2.content = 0;
        R2.bin = "00010";
        R3.address = 3;
        R3.content = 0;
        R3.bin = "00011";
        R4.address = 4;
        R4.content = 0;
        R4.bin = "00100";
        R5.address = 5;
        R5.content = 0;
        R5.bin = "00101";
        R6.address = 6;
        R6.content = 0;
        R6.bin = "00110";
        R7.address = 7;
        R7.content = 0;
        R7.bin = "00111";
        R8.address = 8;
        R8.content = 0;
        R8.bin = "01000";
        R9.address = 9;
        R9.content = 0;
        R9.bin = "01001";
        R10.address = 10;
        R10.content = 0;
        R10.bin = "01010";
        R11.address = 11;
        R11.content = 0;
        R11.bin = "01011";
        R12.address = 12;
        R12.content = 0;
        R12.bin = "01100";
        R13.address = 13;
        R13.content = 0;
        R13.bin = "01101";
        R14.address = 14;
        R14.content = 0;
        R14.bin = "01110";
        R15.address = 15;
        R15.content = 0;
        R15.bin = "01111";
        R16.address = 16;
        R16.content = 0;
        R16.bin = "10000";
        R17.address = 17;
        R17.content = 0;
        R17.bin = "10001";
        R18.address = 18;
        R18.content = 0;
        R18.bin = "10010";
        R19.address = 19;
        R19.content = 0;
        R19.bin = "10011";
        R20.address = 20;
        R20.content = 0;
        R20.bin = "10100";
        R21.address = 21;
        R21.content = 0;
        R21.bin = "10101";
        R22.address = 22;
        R22.content = 0;
        R22.bin = "10110";
        R23.address = 23;
        R23.content = 0;
        R23.bin = "10111";
        R24.address = 24;
        R24.content = 0;
        R24.bin = "11000";
        R25.address = 25;
        R25.content = 0;
        R25.bin = "11001";
        R26.address = 26;
        R26.content = 0;
        R26.bin = "11010";
        R27.address = 27;
        R27.content = 0;
        R27.bin = "11011";
        R28.address = 28;
        R28.content = 0;
        R28.bin = "11100";
        R29.address = 29;
        R29.content = 0;
        R29.bin = "11101";
        R30.address = 30;
        R30.content = 0;
        R30.bin = "11110";
        R31.address = 31;
        R31.content = 0;
        R31.bin = "11111";
    }

    public int readData(int address) {
        return getReg(address).content;
    }

    public void writeData(int address, int data, int WERF) {
        if (WERF == 1) {
            if (address == 31) {
                getReg(address).content = 0;
            } else {
                getReg(address).content = data;
            }
        }
    }

    public Reg getReg(int address) {
        for (Reg reg : registers) {
            if (address == reg.address) {
                return reg;
            }
        }
        return null;
    }
}
