package main.display;

import main.entities.Player;
import main.util.Location;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * In Swing input is taken from MouseListeners and KeyListeners.
 *
 * We can declare what we want our input to do in these methods, and then add Input to Screen to make it work.
 */
public class Input implements MouseListener, KeyListener {
    Player p;
    Input(Player p){
        this.p = p;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // For example:
        // if (e.getKeyChar() == 'a') doThing();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch( keyCode ) {
            case KeyEvent.VK_UP:
                p.getLocation().setY(p.getLocation().getY()+2);
                break;
            case KeyEvent.VK_DOWN:
                p.getLocation().setY(p.getLocation().getY()-2);
                break;
            case KeyEvent.VK_LEFT:
                p.getLocation().setX(p.getLocation().getX()-2);
                break;
            case KeyEvent.VK_RIGHT :
                p.getLocation().setX(p.getLocation().getX()+2);
                break;
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

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
