package com.wtc.avaj.simulator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static final String fileName = "simulation.txt";
    private static Logger logger = null;
    private FileWriter fileWriter;


    private Logger(){

        try {
            fileWriter = new FileWriter(fileName, false);

        } catch (IOException e) {
            System.out.println("Failed to write to " + fileName);
        }
    }

    public static  Logger getLogger(){
        if (logger == null){
            synchronized (Logger.class){
                logger = new Logger();
            }
        }
        return logger;
    }

    public void flyerLog(Flyable flyer, String msg){
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("%s: %s\n", flyer.toString(), msg);
        //printWriter.close();
    }

    public void towerLog(String msg){
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("Tower says: %s\n",  msg);
        //printWriter.close();
    }
}
