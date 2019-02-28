/*
 * @author: Martins Anerua.
 * Martins Anerua © 2018.
 * All rights reserved.
 */
package anerua.safe.hardware;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * 17-11-2018
 *
 * @author MARTINS
 */
public class Memory {

    String instruction_mem = "/anerua/safe/hardware/instruction_mem",
            data_mem = "/anerua/safe/hardware/data_mem";

    public static String readInstruction(int address) {
        Memory mem = new Memory();
        String line = null;
        try (Stream<String> lines = Files.lines(Paths.get(Memory.class.getResource(mem.instruction_mem).toURI()))) {
            line = lines.skip(address / 4).findFirst().get();
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return line;
    }

    public static void writeInstruction(int address, String data) {
        try {
            Memory mem = new Memory();
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(Memory.class.getResource(mem.instruction_mem).toURI()), StandardCharsets.UTF_8));
            fileContent.set(address / 4, data);
            Files.write(Paths.get(Memory.class.getResource(mem.instruction_mem).toURI()), fileContent, StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static int readData(int address) {
        Memory mem = new Memory();
        String line = null;
        try (Stream<String> lines = Files.lines(Paths.get(Memory.class.getResource(mem.data_mem).toURI()))) {
            line = lines.skip(address / 4).findFirst().get();
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Problem with block?
        if (line.equals("")) {
            line = "0";
        }

        return Integer.parseInt(line);
    }

    public static void writeData(int address, int data, int WR) {
        if (WR == 1) {
            try {
                Memory mem = new Memory();
                List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get(Memory.class.getResource(mem.data_mem).toURI()), StandardCharsets.UTF_8));
                fileContent.set(address / 4, Integer.toString(data));
                Files.write(Paths.get(Memory.class.getResource(mem.data_mem).toURI()), fileContent, StandardCharsets.UTF_8);
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(Memory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
