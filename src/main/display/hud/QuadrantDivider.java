package main.display.hud;

import main.util.Globals;

import java.awt.*;

public class QuadrantDivider implements HUDComponent {

    private int screenWidth = (int) (Globals.constant("TILE_SIZE") * Globals.constant("COLUMN_#"));
    private int screenHeight = (int) (Globals.constant("TILE_SIZE") * Globals.constant("ROW_#"));


    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        //Vertical Line
        g.fillRect((screenWidth/2) - 5, 0,  10, screenHeight);
        //Horizontal Line
        g.fillRect(0, (screenHeight/2) - 5, screenWidth, 10);
    }

}
