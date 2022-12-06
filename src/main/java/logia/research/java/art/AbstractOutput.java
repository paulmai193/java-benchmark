package logia.research.java.art;

import logia.research.java.art.entity.Item;

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
