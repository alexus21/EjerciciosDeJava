import java.util.Scanner;

public class Store {

    Scanner in = new Scanner(System.in);
    int ticketsToSale = 0;
    int ticketsToBuy = 0;
    float ticketsPrice = 0f;
    String proceed;


    public void showMenu(){
        System.out.println("Options menu");
        System.out.println("1. Show what we have");
        System.out.println("2. Sale tickets");
        System.out.println("3. Buy tickets");
        System.out.println("4. Exit");
        System.out.print("> ");
    }

    public void saleTickets(){
        System.out.print("Total tickets to sale: ");
        ticketsToSale = in.nextInt();

        System.out.print("Ticket price: ");
        ticketsPrice = in.nextFloat();

        try{
            new Tickets(ticketsToSale, ticketsPrice);
            System.out.println("Tickets successfully sold");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void buyTickets(){
        System.out.print("Total tickets to buy: ");
        ticketsToBuy = in.nextInt();

        System.out.print("Price: " + ticketsToBuy*4.95 + "Proceed? [y/n]: ");
        proceed = in.next();

        if(proceed.equals("y")){
            try{
                new Tickets(ticketsToBuy);
                System.out.println("Tickets successfully bought");
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Cancelled");
        }
    }

    public void showInfo(){
        new Tickets();
    }
}
