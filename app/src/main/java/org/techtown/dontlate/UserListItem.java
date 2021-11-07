package org.techtown.dontlate;

public class UserListItem {

    String placeName;
    String address;

    public UserListItem(String placeName, String address) {
        this.placeName = placeName;
        this.address = address;
    }

    public String getplaceName() {
        return placeName;
    }

    public void setplaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }
}
