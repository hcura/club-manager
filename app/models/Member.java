package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Clube member
 *
 * @author Hugo Cura
 */
public class Member extends Entity {

    private String memberId;
    private String name;
    private List<Address> addresses;

    public Member() {
        super();
        addresses = new ArrayList<>();
    }
}
