package model;

public class Bid {

    private Bidder bidder;
    private BiddingItem item;
    private double amount;


    public Bidder getBidder() {
        return bidder;
    }

    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }

    public BiddingItem getItem() {
        return item;
    }

    public void setItem(BiddingItem item) {
        this.item = item;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Bid(Bidder bidder, BiddingItem item, double amount) {
        this.bidder = bidder;
        this.item = item;
        this.amount = amount;
    }
}
