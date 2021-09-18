package main.display;

import main.core.Updatable;
import main.entities.Player;
import main.util.Globals;
import main.util.Location;
import main.util.ResourceManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Screen extends JPanel {

    //Everything we want drawn on the screen.
    private final List<Renderable> renderableList = new ArrayList<>();
    //Everything that is currently being drawn on the screen that we want to remove.
    private final List<Renderable> renderableRemove = new ArrayList<>();

    //Everything we want updated every frame.
    private final List<Updatable> updatableList = new ArrayList<>();
    private final List<Updatable> updatableRemove = new ArrayList<>();

    private TileManager tileManager;
    private Input input;

    public Screen() {
        //Set the size of the screen to the (number of columns * their size, number of rows * their size)
        setPreferredSize(new Dimension((int)(Globals.constant("TILE_SIZE") * Globals.constant("COLUMN_#")),
                (int)(Globals.constant("TILE_SIZE") * Globals.constant("ROW_#"))));
        setBackground(Color.GRAY);

        Player player = new Player(new Location(12,12));
        input = new Input(player);
        this.addKeyListener(input);
        this.addMouseListener(input);

        tileManager = new TileManager();
        addRenderable(tileManager);

        try {
            ResourceManager.initialize("resources");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The paintComponent method is called multiple times a second and draws whatever we put inside.
     * #kian note: JPanel defaults to executing paintComponent multiple times per second
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //This line calls the default paintComponent which clears the screen.

        for (Renderable r: renderableList) r.render(g); // Draw everything we know about
        for (Updatable u: updatableList) u.update(); // Update what needs to be updated.

        //We can only remove things from these lists in the paintComponent() method or java gets mad.
        renderableList.removeAll(renderableRemove);
        renderableRemove.clear();

        updatableList.removeAll(updatableRemove);
        updatableList.clear();
    }

    public void addUpdatable(Updatable u) {
        updatableList.add(u);
    }

    public void removeUpdatable(Updatable u) {
        updatableList.remove(u);
    }

    public void addRenderable(Renderable r) {
        renderableList.add(r);
    }

    public void removeRenderable(Renderable r) {
        renderableRemove.add(r);
    }
}
