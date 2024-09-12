package useCases.services;

import model.Bidder;

public interface IBidderService {

    void addBidder(Bidder bidder);
    Bidder findBidderById(int id);
}
