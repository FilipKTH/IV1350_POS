package se.kth.iv1350.view;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.controller.OperationFailedException;
import se.kth.iv1350.integration.PurchaseItemDTO;

/**
 * @author Filip
 * This program does not have an actual view.
 * View is insteas used as a placeholder for
 * a real view.
 */
public class View {
    java.util.Scanner in;   //For testing, not part of the actual program
    double runningTotal;    //For testing, not part of the actual program
    double VAT;             //For testing, not part of the actual program

    private Controller cntrl;

    /***
     *
     * @param cntrl The controller used for all operations..
     */
    public View(Controller cntrl) {
        in = new java.util.Scanner(System.in);
        runningTotal = 0;
        VAT = 0;
        this.cntrl = cntrl;
    }

    //All methods below are not apart of the actual program, they are just for testing
    public void run() throws Exception{
            System.out.println("Init working...");
            scanItems();
            pay();
    }

    void scanItems()throws Exception{
        System.out.println("Availible items: apple, food, desk, pasta and bed");
        String input = in.nextLine();
        int amount;
        while (!input.equals("done")){
            amount = in.nextInt();

            try {
                PurchaseItemDTO item = cntrl.scanItem(input, amount);
                if (item.getAmount() != amount) {
                    runningTotal += (item.getAmount() - amount) * item.getPrice();
                    VAT += (item.getAmount() - amount) * item.getVAT();
                } else {
                    runningTotal += item.getAmount() * item.getPrice();
                    VAT += item.getAmount() * item.getVAT();
                }
                displayInfo(item);
            }
            catch (OperationFailedException exc){
                System.out.println("Try scanning again, or contact the manager.");
            }
                in.nextLine();
                input = in.nextLine();

        }
    }

    void displayInfo(PurchaseItemDTO item){
        System.out.println("Total: " + runningTotal);
        System.out.println(item.getItemDescription());
        System.out.println("Quantity; " + item.getAmount());
        System.out.println("Price: " + item.getPrice() +
                " per " + item.getItemID());
    }

    void pay() throws Exception{
        System.out.println("Total: " + runningTotal + " VAT; " + VAT);
        System.out.println("Pay:");
        System.out.println("Change: " + cntrl.pay(in.nextDouble()));
    }

}
