package logia.research.java.structure.entity;

import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class Package {
    private String code;
    private ZonedDateTime datePack;
    private float totalAmount;
    private float width;
    private float length;
    private float height;
    private float weight;
    private List<Item> items; // Relationship
}
