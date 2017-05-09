/**
 * Created by serinahu on 5/8/17.
 */

import org.newdawn.slick.*;
import org.newdawn.slick.tiled.*;

import static java.lang.Integer.parseInt;

public class Map {
    private TiledMap map;
    // dimensions in tiles
    int height;
    int width;
    int tileHeight;
    int tileWidth;
    // dimensions in pixels
    int pixelHeight;
    int pixelWidth;
    // list of entries
    // list of trigger-able things

    public Map() throws SlickException {
        this("maps/sample.tmx");
    }

    public Map(String filePath) throws SlickException {
        map = new TiledMap(filePath);
        height = map.getHeight();
        width = map.getWidth();
        tileHeight = map.getTileHeight();
        tileWidth = map.getTileWidth();
        pixelHeight = height * tileHeight;
        pixelWidth = width * tileWidth;
    }

    public void render(int xPos, int yPos) {
        map.render(xPos, yPos);
    }

    public boolean isBlocked(float xPos, float yPos) {
        if (xPos < 0 || yPos < 0 || xPos > pixelWidth || yPos > pixelHeight) {
            return true;
        }
        int tileID = map.getTileId((int) xPos / tileWidth, (int) yPos / tileHeight, map.getLayerIndex("Blocked"));
        return map.getTileProperty(tileID, "Blocked", "false").equals("true");
    }

    public boolean isEntry(float xPos, float yPos) {
        if (xPos < 0 || yPos < 0 || xPos > pixelWidth || yPos > pixelHeight) {
            return false;
        }
        int tileID = map.getTileId((int) xPos / tileWidth, (int) yPos / tileHeight, map.getLayerIndex("Entries"));
        return !map.getTileProperty(tileID, "entryInfo", "").equals("");
    }

    public int[] getEntry(float xPos, float yPos) {
        int tileID = map.getTileId((int) xPos / tileWidth, (int) yPos / tileHeight, map.getLayerIndex("Entries"));
        String[] data = map.getTileProperty(tileID, "entryInfo", "").split("_");
        int[] new_data = {parseInt(data[0]), parseInt(data[1]), parseInt(data[2])};
        return new_data;
    }
}