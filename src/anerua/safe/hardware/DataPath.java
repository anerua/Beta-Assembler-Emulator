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
// This class is responsible for processing the machine code in memory
public class DataPath {

    PC pc = new PC();

    /**
     *
     * @param op = opcode integer representation
     * @param Ra = first register
     * @param Rb = second register or a constant
     * @param Rc = third register
     * @param registers = register file in use
     */
    public void path(int op, int Ra, int Rb, int Rc, Registers registers) {

        int nextPC = pc.pc + 4;

        int alufn = Control.ALUFN(op),
                wdsel = Control.WDSEL(op),
                ra2sel = Control.RA2SEL(op),
                wr = Control.WR(op),
                werf = Control.WERF(op),
                bsel = Control.BSEL(op),
                pcsel = Control.PCSEL(op, NOR(registers.readData(Ra)));

        if (ra2sel == 1) {      // ??? I'm still confused as to why I wrote this conditional statement
//           Rb = Rc;
        }

        //  Output of Register file
        int RA = registers.readData(Ra),
                //           RB = ,     // ??? confused too
                JT = registers.readData(Ra);

        switch (pcsel) {
            case 0:
                pc.pc = nextPC;
                break;
            case 1:
                pc.pc = nextPC + literal(Rb, pc.pc);
                break;
            case 2:
                pc.pc = JT;
                break;
            case 3:
                break;
            case 4:
                break;
        }

        int A = RA,
                B = 0;

        switch (bsel) {
            case 1:
                B = Rb;
                break;
            case 0:
                B = registers.readData(Rb);
                break;
            default:
                // return error
                break;
        }

        int C = ALU.logic(A, B, alufn);             // output from ALU

        try {
            Memory.writeData(ALU.logic(Rb, registers.readData(Rc), alufn), registers.readData(Ra), wr);                // Data Memory operations 
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero");
        }
        int wd = 0;
        switch (wdsel) {
            case 2:
                wd = Memory.readData(C);                // Data read output
                break;
            case 1:
                wd = C;
                break;
            case 0:
                wd = nextPC;
            default:
                // error
                break;
        }

        registers.writeData(Rc, wd, werf);           // write data to registers
    }

    // Entry point for the class
    // Responsible for running machine code line by line
    public void runCommand(Registers registers) {
        while (true) {
            try {
                String line = Memory.readInstruction(pc.pc);
                if (!line.equals("")) {
                    System.out.println(line);
                    String[] args = line.split(",");
                    path(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), registers);
                } else {
                    break;
                }
            } catch (NumberFormatException e) {     // ??? maybe this exception is not needed
                break;
            }
        }
    }

    public boolean NOR(int i) {
        return i == 0;
    }

    public int offset(int i) {
        return (int) (i & ~Integer.toUnsignedLong(3));
    }

    public int literal(int label, int pc) {
        return 4 * (((offset(label) - offset(pc)) / 4) - 1);
    }

}
