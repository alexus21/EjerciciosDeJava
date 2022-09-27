import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Store store = new Store();
        Scanner in = new Scanner(System.in);
        int selectedOption;
        String continueOperation;

        do{
            store.showMenu();
            selectedOption = in.nextInt();

            switch (selectedOption) {
                case 1 -> store.showInfo();
                case 2 -> store.saleTickets();
                case 3 -> store.buyTickets();
                case 4 -> System.out.println("Cancelled");
                default -> System.out.println("Error: no available option");
            }
            System.out.print("Continue? [y/n]: ");
            continueOperation = in.next();
        }while(continueOperation.equals("y"));
    }
}
