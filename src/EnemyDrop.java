import java.lang.annotation.Target;

/**
 * Created by serinahu on 5/13/17.
 */
public class EnemyDrop {
    Item item;
    float chance;
    public EnemyDrop(Item item, float chance) {
        this.item = item;
        this.chance = chance;
    }
}