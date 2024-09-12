package useCases.services;

import model.BiddingItem;

import java.util.List;

public interface IItemService {

    void addBiddingItem(BiddingItem item);
    BiddingItem findItemById(int id);
    List<BiddingItem> findAllItems();
}
