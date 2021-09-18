package main.display;

import main.util.Globals;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class Screen extends JPanel {

    //Everything we want drawn on the screen.
    private final List<Renderable> renderableList = new ArrayList<>();
    //Everything that is currently being drawn on the screen that we want to remove.
    private final List<Renderable> toRemove = new ArrayList<>();

    private Input input;

    public Screen() {
        //Set the size of the screen to the (number of columns * their size, number of rows * their size)
        setPreferredSize(new Dimension((int)(Globals.constant("TILE_SIZE") * Globals.constant("COLUMN_#")),
                (int)(Globals.constant("TILE_SIZE") * Globals.constant("ROW_#"))));
        setBackground(Color.GRAY);

        input = new Input();
        this.addKeyListener(input);
        this.addMouseListener(input);
    }

    /**
     * The paintComponent method is called multiple times a second and draws whatever we put inside.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //This line calls the default paintComponent which clears the screen.

        for (Renderable r: renderableList) r.render(g); // Draw everything we know about

        //We can only remove things from renderableList in the paintComponent() method or java gets mad.
        renderableList.removeAll(toRemove);
        toRemove.clear();
    }

    public void addRenderable(Renderable r) {
        renderableList.add(r);
    }

    public void removeRenderable(Renderable r) {
        toRemove.add(r);
    }
}
