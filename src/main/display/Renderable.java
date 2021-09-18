package main.display;

import java.awt.*;

/**
 * An interface is just a class that forces you to create any methods in it. In this case any class that
 * "implements" Renderable will need to have the render() function inside. This is useful because now the Screen class
 * can now see what objects can be rendered.
 */
public interface Renderable {
    void render(Graphics g);
}
