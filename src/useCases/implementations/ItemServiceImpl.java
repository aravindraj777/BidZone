package useCases.implementations;

import model.BiddingItem;
import useCases.services.IItemService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemServiceImpl  implements IItemService {

    private List<BiddingItem> biddingItems = new ArrayList<>();


    @Override
    public void addBiddingItem(BiddingItem item) {
        biddingItems.add(item);
    }

    @Override
    public BiddingItem findItemById(int id) {

        for (BiddingItem biddingItem : biddingItems){
            if (biddingItem.getId() == id){
                return biddingItem;
            }
        }
        return null;
    }

    @Override
    public List<BiddingItem> findAllItems() {
        return new ArrayList<>(biddingItems);
    }
}
