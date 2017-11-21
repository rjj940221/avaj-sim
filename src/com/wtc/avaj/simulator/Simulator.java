package com.wtc.avaj.simulator;

import com.wtc.avaj.simulator.Exceptions.SimValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simulator {
    public static void main(String[] args) {
        String line;
        try {
            if (args.length == 1){
                BufferedReader br = new BufferedReader(new FileReader(args[0]));
                int num_sim = Integer.parseInt(br.readLine().trim());
                if (num_sim < 0)
                {
                    throw new SimValidation("Negative number of simulations");
                }
                Pattern p = Pattern.compile("a*b");
                Matcher m = p.matcher("aaaaab");
                while ((line =  br.readLine()) != null){

                }
            }else
            {
                System.out.println("incorect number of files passed to simulation");
            }
        }catch (SimValidation ignored){
            System.out.println(ignored.getMessage());
        }
        catch (Exception e) {
            System.out.println("Simulation quit unexpectidly");
        }
    }
}
