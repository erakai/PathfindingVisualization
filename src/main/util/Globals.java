package main.util;

import java.util.HashMap;
import java.util.Map;

public class Globals {
    private Globals() {}

    static {
        createConstant("DISPLAY_SCALE", 1.0);
        createConstant("FRAMES_PER_SECOND", 30);
        createConstant("TILE_SIZE", 32);
    }

    private final static Map<String, Double> constants = new HashMap<>();

    public static void createConstant(String name, double value) {
        constants.put(name, value);
    }

    public static double constant(String name) {
        return constants.get(name);
    }
}
