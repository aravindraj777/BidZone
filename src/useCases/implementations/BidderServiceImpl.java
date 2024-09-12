package useCases.implementations;

import model.Bidder;
import useCases.services.IBidderService;

import java.util.ArrayList;
import java.util.List;

public class BidderServiceImpl implements IBidderService {

    private List<Bidder> bidders = new ArrayList<>();


    @Override
    public void addBidder(Bidder bidder) {
        bidders.add(bidder);
    }

    @Override
    public Bidder findBidderById(int id) {

        for (Bidder bidder : bidders){
            if (bidder.getId() == id){
                return bidder;
            }
        }
        return null;
    }
}
