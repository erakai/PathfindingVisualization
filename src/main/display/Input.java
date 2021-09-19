package main.display;

import main.entities.Player;
import main.util.Globals;

import java.awt.event.*;

/**
 * In Swing input is taken from MouseListeners and KeyListeners.
 *
 * We can declare what we want our input to do in these methods, and then add Input to Screen to make it work.
 */
public class Input implements MouseListener, KeyListener, MouseMotionListener {
    private Player p;
    private TileManager tileManager;
    private boolean pressed = false;

    public Input(Player p, TileManager tileManager){
        this.p = p;
        this.tileManager = tileManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // For example:
        // if (e.getKeyChar() == 'a') doThing();
    }
    //player controls movement of player with arrow keys
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == e.VK_UP) {
            if (p.getLocation().getY() <= 0)
            {} else {
                p.getLocation().setY(p.getLocation().getY() - 32);
            }
        }
        //(p.getLocation().getY() <= 0)
        if (e.getKeyCode() == e.VK_DOWN) {
            if (p.getLocation().getY() >= (int)Globals.constant("TILE_SIZE") * ((int)Globals.constant("ROW_#")-1))
            {} else {
                p.getLocation().setY(p.getLocation().getY() + 32);
            }
        }
        if(e.getKeyCode() == e.VK_LEFT) {
            if (p.getLocation().getX() <= 0)
            {} else {
                p.getLocation().setX(p.getLocation().getX() - 32);
            }
        }
        //works
        if (e.getKeyCode() == e.VK_RIGHT) {
            if (p.getLocation().getX() >= (int)Globals.constant("TILE_SIZE") * ((int)Globals.constant("COLUMN_#")-1))
            {} else {
                p.getLocation().setX(p.getLocation().getX() + 32);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    /*
    Here we get the x and y of the mouse where it was clicked [and RELEASED] and then convert those coordinates
    to the tile at that location and then sets that tile then runs setWall to make that tile into an
    immovable and impassable object that is a real force to be reckoned with if I'm going to be completely honest
    like wow that wall is large and very hard so your punches will not do ANYTHING to it you could probably drop
    a couple of nuclear bombs in the area and the wall will still be there, suspended in air, because of just how
    much the sheer power of it's will allows it to defy the laws of physics. Wall.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;

        int x = e.getX();
        int y = e.getY();

        int tileX = x / (int) Globals.constant("TILE_SIZE");
        int tileY = y / (int) Globals.constant("TILE_SIZE");

        try {
            if (!tileManager.getTile(tileX, tileY).isOccupied()) {
                tileManager.setWall(tileY, tileX);
            }
        } catch (Exception ignored) {}
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (pressed) {
            int x = e.getX();
            int y = e.getY();

            int tileX = x / (int) Globals.constant("TILE_SIZE");
            int tileY = y / (int) Globals.constant("TILE_SIZE");

            try {
                if (!tileManager.getTile(tileX, tileY).isOccupied()) {
                    tileManager.setWall(tileY, tileX);
                }
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
