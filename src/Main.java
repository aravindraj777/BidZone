import useCases.implementations.BidServiceImpl;
import useCases.implementations.BidderServiceImpl;
import useCases.implementations.ItemServiceImpl;
import useCases.services.BiddingService;
import useCases.services.IBidService;
import useCases.services.IBidderService;
import useCases.services.IItemService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        IBidderService bidderService = new BidderServiceImpl();
        IItemService itemService = new ItemServiceImpl();
        IBidService bidService = new BidServiceImpl(itemService);
        BiddingService service = new BiddingService(bidderService,itemService,bidService);
        service.showMenu();


    }
}