package logia.research.java.art;

import logia.research.java.art.entity.Item;
import logia.research.java.art.entity.Box;

public class AbstractInput {
    public static void main(String[] args) {
        Item item = new Item();
        calculateVolumeItem(item);

        Box box = new Box();
        calculateVolumePackage(box);
    }

    public static float calculateVolumeItem(Item item) {
        return item.getWidth() * item.getLength() * item.getHeight();
    }

    public static float calculateVolumePackage(Box box) {
        return box.getWidth() * box.getLength() * box.getHeight();
    }
}
