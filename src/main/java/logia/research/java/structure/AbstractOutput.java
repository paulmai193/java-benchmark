package logia.research.java.structure;

import logia.research.java.structure.entity.Item;

public class AbstractOutput {

    private ItemLocatorService itemLocatorService;

    public void getItem() {
        byte rackNo = 69, shelveNo = 7;
        Item found = itemLocatorService.getByLocation(rackNo, shelveNo);
    }

}

class ItemLocatorService {
    public Item getByLocation(byte rackNo, byte shelveNo) {
        // TODO something
        return new Item();
    }
}
