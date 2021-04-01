package com.tcodes;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private Map<Character, Integer> charCounts;

    public Main()
    {
        charCounts = new HashMap<>();
    }

    public static void main(String[] args) {
        Main main = new Main();

        File filein = new File(args[0]);
        File fileout = new File(args[1]);

        printToFile(main.getAllCounts(filein), fileout);
    }

    public static void printToFile(Map<Character, Integer> charCounts, File out) {
        try {
            FileWriter fileWriter = new FileWriter(out);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Character c :
                    charCounts.keySet()) {
                printWriter.print(c + " = ");
                printWriter.println(charCounts.get(c).toString());
            }

            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Character, Integer> getAllCounts(File file)
    {
        try {
            FileReader fileReader = new FileReader(file);
            int i;
            while ((i = fileReader.read()) != -1)
                addCharacter((char) i);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return charCounts;
    }

    private void addCharacter(Character character)
    {
        if(charCounts.containsKey(character)){
            int newCnt = charCounts.get(character) + 1;
            charCounts.put(character, newCnt);
        }
        else {
            charCounts.put(character, 1);
        }
    }
}
