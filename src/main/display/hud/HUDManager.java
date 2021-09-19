package main.display.hud;

import main.core.Updatable;
import main.display.Renderable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HUDManager implements HUDComponent {
    private List<HUDComponent> components;

    public HUDManager() {
        components = new ArrayList<>();

        components.add(new QuadrantDivider());
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
