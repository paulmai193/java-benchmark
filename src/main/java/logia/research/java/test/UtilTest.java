package logia.research.java.test;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class UtilTest {
    public static void main(String[] args) {
        String[] userParts = "GOSELL_STORE_207248".split(Pattern.quote("_"));
        if (userParts.length < 2) {
            System.out.println("NULL");
        }
        String userIdAsString = userParts[userParts.length - 1]; // Last index is represent for userID
        Long userId = Long.parseLong(userIdAsString);
        System.out.println("UserID: " + userId);
        String userTypeName = StringUtils.joinWith("_", ArrayUtils.subarray(userParts, 0, userParts.length - 1));;
        System.out.println("UserType: " + userTypeName);
    }
}
