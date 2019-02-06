/**
 * TicketMachine models a naive ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * It is a naive machine in the sense that it trusts its users
 * to insert enough money before trying to print a ticket.
 * It also assumes that users enter sensible amounts.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
  public class  TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //Exercise 2.15
    private int status;
    
    

    /**
     * Create a machine that issues tickets of the given price.
     * Note that the price must be greater than zero, and there
     * are no checks to ensure this.
     */
    public TicketMachine()
    {
        price = 1000;
        balance = 0;
        total = 0;
    }
    
    public TicketMachine(int inputPrice)
    {
     price = inputPrice;  
    }
    
    
        
    

    /**
     * Return the price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return the amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money in cents from a customer.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
         balance = balance + amount;   
        }
        else{
         System.out.println("Use a positive amount: " + amount);   
        }
    }
    
    public int getTotal()
    {
        return total;
    }
    
    public void prompt()
    {
     System.out.println("Please insert the correct amount of money.");   
    }
    
    public void showPrice()
    {
     System.out.println("The price of a ticket is " + price + " cents.");  
    }
    //Exercise 2.55
    public int emptyMachine()
    {
        int totalRemoved = total;
        total = 0;   
        return totalRemoved;
    }
    //Exercise 2.56 emptyMAchine is both mutator and accessor becuase
    //it returns a value to the caller while muating the total to zero 
    public void setPrice(int newPrice)
    {
     price = newPrice;   
    }
    //Exercise 2.49
    public void currentDiscount(int discount)
    {
        int saving = price * discount;
    }
    //Exercise 2.50
    // int mean = total / count
    
    /**Exercise 2.51 and 2.52
     * 
     * if(price > budget){
     * System.out.println("Too Expensive! Your budget is currently: "
     * + budget);
     * }
     * else{
     * System.out.println("Just Right");
     * }
     */
    //Execise 2.53 return should be the final line of the method
    /**
     * Print a ticket.
     * Update the total collected and
     * reduce the balance to zero.
     */
    public void printTicket()
    {
        int amountLeftToPay = price - balance;
        if(amountLeftToPay <= 0){
            
      
        // Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        // Update the total collected with the balance.
        total += price;
        //Reduce balance by price to get change
        balance -= price;
    }
    else{
        System.out.println("You must insert at least: " 
        + amountLeftToPay + " more cents");
        
        
    }
}
    public int refundBalance()
    {
      int amountToRefund;
      amountToRefund = balance;
      balance = 0;
      return amountToRefund;
}
}
/** Exercise 2.58
 * In order to change ticket price you could set up the constructor to ask 
 * what type of ticket you want when the ticket machine is created. The amount
 * new fields created depends on the amount of ticket choices there are. Each
 * one of these fields would set a different price for the ticket. The rest of
 * code would behave the same once the ticket price was set.
 * 
 * 
 * 
 * 
 * 
 */