package main.util;

import java.util.HashMap;
import java.util.Map;

/**
 * To use global variables (ie variables that can be accessed from everywhere and don't change):
 *
 * Anything in the static{} block is loaded into the constants map (a dictionary) at the start of the program. You can
 * access any of these constants by using the constant(name) method.
 *
 * If you need to create a constant "HEALTH" call:
 * Globals.createConstant("HEALTH", 30.0);
 *
 * If you need to retrieve "HEALTH" call:
 * Globals.constant("HEALTH");
 */
public class Globals {
    private Globals() {}

    private final static Map<String, Double> constants;

    static {
        constants = new HashMap<>();

        createConstant("DISPLAY_SCALE", 1.0);
        createConstant("FRAMES_PER_SECOND", 30);
        createConstant("TILE_SIZE", 24);
        createConstant("ROW_#", 28);
        createConstant("COLUMN_#", 28);
    }

    public static void createConstant(String name, double value) {
        constants.put(name, value);
    }

    public static double constant(String name) {
        return constants.get(name);
    }
}
