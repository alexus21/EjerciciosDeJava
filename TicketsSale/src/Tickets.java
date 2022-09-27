public class Tickets {

    //Available on start:
    private Integer totalAvailableTickets = 500;
    private Float availableMoney = 0f;

    public Tickets(Integer totalToSale, Float ticketPrice){
        try{
            this.saleTickets(totalToSale, ticketPrice);
        }catch(InsufficientTicketsException e){
            System.out.println(e.getMessage());
        }
    }

    public Tickets(Integer totalTicketsToBuy){
        try{
            this.buyMoreTickets(totalTicketsToBuy);
        }catch(InsufficientMoneyException e){
            System.out.println(e.getMessage());
        }
    }

    public Tickets(){
        System.out.println(this.showAvailableTickets());
        System.out.println(this.showAvailableMoney());
    }

    boolean sufficientTickets(Integer requestedTickets){
        return this.totalAvailableTickets >= requestedTickets;
    }

    boolean sufficientMoney(Float money){
        return this.availableMoney >= money;
    }

    public Integer showAvailableTickets(){
        return this.totalAvailableTickets;
    }

    public Float showAvailableMoney(){
        return this.availableMoney;
    }

    void saleTickets(Integer totalTicketsToSale, Float ticketPrice) throws InsufficientTicketsException{

        if(sufficientTickets(totalTicketsToSale)){
            this.totalAvailableTickets = this.totalAvailableTickets - totalTicketsToSale;
            this.availableMoney = this.availableMoney + ticketPrice;
        }else{
            throw new InsufficientTicketsException("Insufficient tickets. Please, get more");
        }
    }

    void buyMoreTickets(Integer totalTicketsToBuy) throws InsufficientMoneyException {

        float money = totalTicketsToBuy * 4.95f;

        if (sufficientMoney(money)){
            this.totalAvailableTickets = this.totalAvailableTickets + totalTicketsToBuy;
            this.availableMoney = availableMoney - money;
        }
        else
            throw new InsufficientMoneyException("Insufficient money");
    }
}
