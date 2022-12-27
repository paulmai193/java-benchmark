package logia.research.java.quicktest;

public class BitTest {
    static final byte view = 1;      // 0001
    static final byte create = 2;    // 0010
    static final byte update = 4;    // 0100
    static final byte delete = 8;    // 1000

    public static void main(String[] args) {
        System.out.println("view - " + Integer.toBinaryString(view));
        System.out.println("create - " + Integer.toBinaryString(create));
        System.out.println("update - " + Integer.toBinaryString(update));
        System.out.println("delete - " + Integer.toBinaryString(delete));
        byte view_update_delete = view | update | delete;
        System.out.println(view_update_delete + " - " + Integer.toBinaryString(view_update_delete));
        System.out.println("Allow view: " + ((view_update_delete & view) > 0)); // true
        System.out.println("Allow delete: " + ((view_update_delete & delete) > 0)); // true
        System.out.println("Allow create: " + ((view_update_delete & create) > 0)); // false
    }
}
