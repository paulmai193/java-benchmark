package logia.research.java.structure;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

public class PreferAbstract {

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

@Data
class Item {
    private String name;
    private String description;
    private float price;
    private float width;
    private float length;
    private float height;
    private float weight;
}

@Data
class Package {
    private String code;
    private ZonedDateTime datePack;
    private List<Item> items;
    private float totalAmount;
    private float width;
    private float length;
    private float height;
    private float weight;
}

interface Dimension {
    float getWidth();
    float getLength();
    float getHeight();
}
