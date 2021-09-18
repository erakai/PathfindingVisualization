package main.core;

/**
 * Look at the Renderable interface for another example of an interface. This just marks a class as wanting to be
 * updated. For example, a player class needs to be updated every frame in case it's moving to change its location.
 * In practice, we will call every class that implement's Updatable's update() method whenever we draw it in Screen.
 */
public interface Updatable {
    void update();
}
