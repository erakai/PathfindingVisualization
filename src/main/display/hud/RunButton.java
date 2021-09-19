package main.display.hud;

import main.util.Globals;

import java.awt.*;

public class RunButton implements HUDComponent {
    public static boolean RUN = false;

    private int screenWidth = (int) (Globals.constant("TILE_SIZE") * Globals.constant("COLUMN_#"));
    private int screenHeight = (int) (Globals.constant("TILE_SIZE") * Globals.constant("ROW_#"));

    private int x = screenWidth + 10;
    private int y = screenHeight / 2 - 10;

    public void checkPressed(int mX, int mY) {
        if (mX > x && mX < x + 80 && mY > y && mY < y + 40) {
            RUN = true;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawRect(screenWidth + 10, screenHeight / 2 - 10, 80, 40);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(screenWidth + 10 + 1, screenHeight / 2 - 10 + 1, 79, 39);
        g.setFont(new Font(g.getFont().getName(), g.getFont().getStyle(), g.getFont().getSize()*2));
        g.setColor(Color.BLACK);
        g.drawString("RUN", screenWidth + 20, screenHeight / 2 + 20);

        g.setFont(new Font(g.getFont().getName(), g.getFont().getStyle(), g.getFont().getSize()/2));
        g.setColor(Color.WHITE);
        g.drawString("TL: Breadth-First", screenWidth + 5, 30);
        g.drawString("TR: Dijkstra's", screenWidth + 5, 60);
        g.drawString("BL: A*", screenWidth + 5, 90);
        g.drawString("BR: Kian*", screenWidth + 5, 120);
    }
}
