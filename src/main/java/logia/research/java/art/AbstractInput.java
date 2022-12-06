package logia.research.java.art;

import logia.research.java.art.entity.Item;
import logia.research.java.art.entity.Package;

public class AbstractInput {
    public static void main(String[] args) {
        Item item = new Item();
        calculateVolumeItem(item);

        Package aPackage = new Package();
        calculateVolumePackage(aPackage);
    }

    public static float calculateVolumeItem(Item item) {
        return item.getWidth() * item.getLength() * item.getHeight();
    }

    public static float calculateVolumePackage(Package aPackage) {
        return aPackage.getWidth() * aPackage.getLength() * aPackage.getHeight();
    }
}
