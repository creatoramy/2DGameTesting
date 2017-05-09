/**
 * Created by serinahu on 5/3/17.
 */

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MapState extends BasicGameState {

    private int id;
    int currentMapID;
    Map currentMap;
    private Entity leader;

    public MapState(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        currentMap = Resources.map_db[currentMapID];
        leader = Resources.party[0];
    }

    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        currentMap.render(0, 0);
        leader.render(container, game, g);
    }

    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Input input = container.getInput();
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            game.enterState(TestingGame.MAIN_MENU);
        }
        leader.update(container, game, delta, this);
        // if the tile is an entry, change the current map ID and current map
        if (currentMap.isEntry(leader.xPos, leader.yPos)) {
            int[] entryData = currentMap.getEntry(leader.xPos, leader.yPos);
            changeMap(entryData[0]);
            // place the player in the new position
            leader.xPos = currentMap.tileWidth * entryData[1];
            leader.yPos = currentMap.tileHeight * entryData[2];
        }
        // if trigger (NPC, chest), do something
        // if there's a random encounter, change state to combat
    }

    public void changeMap(int newMapID) {
        currentMapID = newMapID;
        currentMap = Resources.map_db[currentMapID];
    }

    public boolean isBlocked(float xPos, float yPos) {
        return currentMap.isBlocked(xPos, yPos);
    }

    public int getHeight() {
        return currentMap.pixelHeight;
    }

    public int getWidth() {
        return currentMap.pixelWidth;
    }
}