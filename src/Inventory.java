/**
 * Created by serinahu on 5/4/17.
 */

import org.newdawn.slick.*;

public class Inventory {

    // a button for highlighting
    // button location (x, y)
    // contains consumables and equips: hash table of items and quantities?

    public Inventory() {

    }

    public void init() {

    }

    public void render(Graphics g) {
        // show a table of items: render each item
        // by default first item is highlighted by the button (should probably handle this in init)
    }

    public void update(int delta) {

    }

    // increase the amount of item by some quantity; should also check if quantity goes over 99
    public void addItem(Item item, int quantity) {

    }

    public void removeItem(Item item, int quantity) {

    }

    public int getQuantity(Item item) {
        return 0;
    }
}
