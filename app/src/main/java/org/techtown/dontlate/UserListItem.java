package org.techtown.dontlate;

public class UserListItem {

    String PlaceName;
    String Address;

    public UserListItem() {
        this.PlaceName = "장소";
        this.Address = "주소";
    }

    public UserListItem(String placeName, String address) {
        this.PlaceName = placeName;
        this.Address = address;
    }

    public String getplaceName() {
        return PlaceName;
    }

    public void setplaceName(String placeName) {
        this.PlaceName = placeName;
    }

    public String getaddress() {
        return Address;
    }

    public void setaddress(String address) {
        this.Address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "placeName='" + PlaceName + '\'' +
                ", address='" + Address + '\'' +
                '}';
    }
}
