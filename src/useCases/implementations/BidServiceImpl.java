package useCases.implementations;

import model.Bid;
import model.Bidder;
import model.BiddingItem;
import useCases.services.IBidService;
import useCases.services.IBidderService;
import useCases.services.IItemService;

public class BidServiceImpl implements IBidService {

    private IItemService itemService;

    public BidServiceImpl(IItemService itemService){
        this.itemService = itemService;
    }


    @Override
    public void placeBid(Bid bid) {

        BiddingItem biddingItem = itemService.findItemById(bid.getItem().getId());
        if (biddingItem != null){
            if (biddingItem.getHighestBid() == null || bid.getAmount() > biddingItem.getHighestBid().getAmount()){
                biddingItem.setHighestBid(bid);
                System.out.println("Bid successfully placed");
            }
            else {
                System.out.println("OOPS!.... Bid amount is lowwww.....");
            }
        }
        else {
            System.out.println("Item Not found");
        }
    }
}
