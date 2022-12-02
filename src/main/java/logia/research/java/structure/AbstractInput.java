package logia.research.java.structure;

import logia.research.java.structure.entity.Item;
import logia.research.java.structure.entity.Package;

public class AbstractInput {
    public static void main(String[] args) {
        Item item = new Item();
        calculateVolumeItem(item);

        Package aPackage = new Package();
        calculateVolumePackage(aPackage);
    }

    public static float calculateVolumeItem(logia.research.java.structure.entity.Item item) {
        return item.getWidth() * item.getLength() * item.getHeight();
    }

    public static float calculateVolumePackage(Package aPackage) {
        return aPackage.getWidth() * aPackage.getLength() * aPackage.getHeight();
    }
}
