package useCases.services;

import model.Bid;
import model.Bidder;
import model.BiddingItem;
import util.Role;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class BiddingService {

    private IBidderService bidderService;
    private IItemService itemService;
    private IBidService bidService;
    private Scanner scanner = new Scanner(System.in);

    public BiddingService(IBidderService bidderService, IItemService itemService, IBidService bidService) {
        this.bidderService = bidderService;
        this.itemService = itemService;
        this.bidService = bidService;
    }

    public void showMenu(){
        boolean isRunning = true;

        while (isRunning){
            System.out.println("1. Add Bidder");
            System.out.println("2. Add Bidding Item");
            System.out.println("3. Place A Bid");
            System.out.println("4. Show Bid Results");
            System.out.println("5. Exit The Application");
            System.out.print("Choose an Option.... ");
            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice){

                case 1: addBidder(); break;
                case 2: addItem(); break;
                case 3: placeBid();break;
                case 4: showResults();break;
                case 5: isRunning = false; break;
                default:
                    System.out.println("Invalid choice ");
                    break;
            }
        }
    }

    private void addBidder(){
        System.out.print("Enter Bidder Id");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter your Bidder name");
        String bidderName = scanner.nextLine().trim();

        System.out.print("Please enter your contact number");
        long bidderPhone = Long.parseLong(scanner.nextLine().trim());

        System.out.print("Are you a BUYER or SELLER ? , please enter");
        String stringRole = scanner.nextLine().toUpperCase().trim();
        Role role = Role.valueOf(stringRole);

        bidderService.addBidder(new Bidder(id,bidderName,bidderPhone,role));
        System.out.println("Bidder Added Successfully");
    }

    private void addItem(){
        System.out.println("Enter the item ID");
        int id = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter the Item name");
        String name = scanner.nextLine().trim();

        System.out.println("Enter the item Description");
        String description = scanner.nextLine().trim();

        System.out.println("Enter your bidder Id");
        int bidderId = Integer.parseInt(scanner.nextLine().trim());
        Bidder seller = bidderService.findBidderById(bidderId);

        if (seller != null && seller.getRole() == Role.SELLER){
            BiddingItem biddingItem = new BiddingItem(id,name,description,null,seller);
            itemService.addBiddingItem(biddingItem);
            System.out.println("Bidding item added successfully");
        }
        else {
            System.out.println("Invalid bidderId , Its not a seller");
        }
    }


    private void placeBid(){
        System.out.println("Enter your BidderId..");
        int bidderId = Integer.parseInt(scanner.nextLine().trim());
        Bidder bidder = bidderService.findBidderById(bidderId);

        if (bidder == null){
            System.out.println("Bidder not Found");
            return;
        }

        if (bidder.getRole() == Role.SELLER){
            System.out.println("OOPS.... Sellers cannot buy their bids...");
            return;
        }

        System.out.println("Enter item id");
        int itemId = Integer.parseInt(scanner.nextLine().trim());
        BiddingItem biddingItem = itemService.findItemById(itemId);

        if (biddingItem == null){
            System.out.println("There is no item...");
            return;
        }

        System.out.println("Enter bid amount..");
        double amount = Double.parseDouble(scanner.nextLine().trim());
        Bid bid  = new Bid(bidder,biddingItem,amount);
        bidService.placeBid(bid);
    }

    private void showResults(){
        for (BiddingItem item : itemService.findAllItems()){
            Bid highestBid = item.getHighestBid();
            if (highestBid != null){
                System.out.println("Item "+item.getName() + "winner "+ highestBid.getBidder().getBidderName());
            }
            else {
                System.out.println("Item "+ item.getName()+ "has no bids");
            }
        }
    }
}
