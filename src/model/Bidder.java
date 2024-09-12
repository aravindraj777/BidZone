package model;

import util.Role;

public class Bidder {

    private int id;
    private String bidderName;
    private long bidderPhone;

    private Role role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBidderName() {
        return bidderName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

    public long getBidderPhone() {
        return bidderPhone;
    }

    public void setBidderPhone(long bidderPhone) {
        this.bidderPhone = bidderPhone;
    }

    public Bidder(int id, String bidderName, long bidderPhone, Role role) {
        this.id = id;
        this.bidderName = bidderName;
        this.bidderPhone = bidderPhone;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Bidder{" +
                "id=" + id +
                ", bidderName='" + bidderName + '\'' +
                ", bidderPhone=" + bidderPhone +
                ", role=" + role +
                '}';
    }
}
