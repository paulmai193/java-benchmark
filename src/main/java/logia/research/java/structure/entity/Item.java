package logia.research.java.structure.entity;

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
    private Package aPackage; // Relationship
}
