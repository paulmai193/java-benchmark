package logia.research.java.art.entity;

import lombok.Data;

@Data
public class Item {
    private String name;
    private String description;
    private float price;
    private float width;
    private float length;
    private float height;
    private float weight;
    private byte rackNo;
    private byte shelveNo;
    private Box box; // Relationship
}
