package com.wtc.avaj.simulator;

import com.wtc.avaj.simulator.exceptions.SimValidation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Simulator {

    private static List<Flyable> flyables = new ArrayList<>();
    private static WeatherTower weatherTower = new WeatherTower();


    private static void addFlyable(String line) {
        String[] args = line.split(" ");
        flyables.add(AircraftFactory.newAircraft(args[0], args[1], Integer.parseInt(args[2]),
                Integer.parseInt(args[3]), Integer.parseInt(args[4])));
    }

    public static void main(String[] args) {
        String line;
        int lineidx = 1;
        try {
            if (args.length == 1) {
                BufferedReader br = new BufferedReader(new FileReader(args[0]));
                int num_sim = Integer.parseInt(br.readLine().trim());
                if (num_sim < 0) {
                    throw new SimValidation("Negative number of simulations");
                }
                Pattern p = Pattern.compile("^(?:Baloon|JetPlane|Helicopter) [BJH]\\d+ \\d+ \\d+ \\d+$");
                Matcher m;
                while ((line = br.readLine()) != null) {
                    lineidx++;
                    m = p.matcher(line);
                    if (!m.matches()) {
                        throw new SimValidation("line: " + lineidx + " Syntax error.");
                    }
                    addFlyable(line);
                }
                for (Flyable flyer : flyables) {
                    flyer.registerTower(weatherTower);
                }
                for (int i = 0; i < num_sim; i++) {
                    weatherTower.changeWeather();
                }
            } else {
                System.out.println("Incorrect number of files passed to simulation");
            }
        } catch (SimValidation ignored) {
            System.out.println(ignored.getMessage());
        }catch (FileNotFoundException e) {
            System.out.println("File "+ args[0] + " not found");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Simulation quit unexpectedly");
        }
    }
}
