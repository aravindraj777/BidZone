package model;

public class BiddingItem {

    private int id;
    private String name;
    private String description;
    private Bid highestBid;
    private Bidder owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bid getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Bid highestBid) {
        this.highestBid = highestBid;
    }

    public Bidder getOwner() {
        return owner;
    }

    public void setOwner(Bidder owner) {
        this.owner = owner;
    }


    public BiddingItem(int id, String name, String description, Bid highestBid, Bidder owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.highestBid = highestBid;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "BiddingItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description;
    }
}
