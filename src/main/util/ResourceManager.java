package main.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Usage of ResourceManager:
 *
 * At the start of the program, when initialize is called by the Game class, every file that ends wtih .png
 * will be loaded in the /resources/ folder. All of these images will be placed into this sprites Map with their
 * name as the key.
 *
 * To access an image in the /resources/ directory:
 *
 * Run ResourceManager.getSprite("[name]")
 * So for pirate.png you can get the image with ResourceManager.getSprite("pirate");
 */
public class ResourceManager {
    private ResourceManager() {}

    private final static Map<String, BufferedImage> sprites = new HashMap<>();
    private static String filePath;

    public static void initialize(String path) throws IOException {
        filePath = path;
        loadSprites(filePath);
    }

    private static void loadSprites(String path) throws IOException {
        File folder = new File(path);
        if (folder.listFiles() == null) {
            System.out.println("Unable to load the /resources/ folder.");
            return;
        }

        for (File f: folder.listFiles()) {
            if (f.isFile() && f.getName().endsWith(".png")) {
                BufferedImage image = (ImageIO.read(Objects.requireNonNull(ResourceManager.class.getResourceAsStream(f.getPath()))));
                sprites.put(f.getName().substring(0,f.getName().indexOf(".")), image);
            } else if (f.isDirectory()) {
                loadSprites(f.getPath());
            }
        }
    }

    public static BufferedImage getSprite(String name) {
        return sprites.get(name);
    }

    public static BufferedImage splice(BufferedImage start, int x, int y, int width, int height) {
        return start.getSubimage(x, y, width, height);

    }
}
