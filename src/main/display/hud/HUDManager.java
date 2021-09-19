package main.display.hud;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HUDManager implements HUDComponent {
    private List<HUDComponent> components;

    public static RunButton run;

    public HUDManager() {
        components = new ArrayList<>();

        run = new RunButton();
        components.add(new QuadrantDivider());
        components.add(run);
    }

    @Override
    public void update() {
        for (HUDComponent hu: components) hu.update();
    }

    @Override
    public void render(Graphics g) {
        for (HUDComponent hu: components) hu.render(g);
    }

    public void removeHUDComponent(HUDComponent hud) {
        components.remove(hud);
    }

    public void addHUDComponent(HUDComponent hud) {
        components.add(hud);
    }
}
