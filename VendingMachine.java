import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
  private int quarters;
  private int dollars;
  private ArrayList<Item> inventory = new ArrayList<Item>();

  public VendingMachine(int pquart, int pdoll) {
    quarters = pquart;
    dollars = pdoll;
  }

  public String fillmachine(Item pitem, int pdoll, int pquart) {
    dollars += pdoll;
    quarters += pquart;
    for (int i = 0; i < inventory.size(); i++) {
      if (pitem.getName().equalsIgnoreCase(inventory.get(i).getName())) {
        inventory.get(i).setAmount(pitem.getAmount());
        inventory.get(i).setPrice(pitem.getPrice());
        return "Successfully updated " + inventory.get(i).getName() + " to amount " + inventory.get(i).getAmount()
            + " and price " + inventory.get(i).getPrice() + "!\nNew Dollar Amount: " + dollars + "\nNew Quater Amount: "
            + quarters;
      }
    }
    inventory.add(pitem);
    return "Successfully added " + pitem.getName() + " with amount " + pitem.getAmount() + " and price "
        + pitem.getPrice() + "!\nNew Dollar Amount: " + dollars + "\nNew Quater Amount: " + quarters;
  }

  public void fillmachine(Item pitem) {
    inventory.add(pitem);
  }

  public void enterMoney(int pdoll, int pquart) {
    mdollars = pdoll;
    mquarters = pquart;
  }

  public ArrayList<Item> getInventory() {
    ArrayList<Item> temp = new ArrayList<Item>();
    for (int i = 0; i < inventory.size(); i++) {
      temp.add(inventory.get(i));
    }
    return temp;
  }

  public Item createItem() {
    System.out.println("What is the name of the item you would like to add to the vending machine?");
    Scanner scan = new Scanner(System.in);
    String itemname = scan.nextLine();
    System.out.println("What is the amount of " + itemname);
    int pamount = scan.nextInt();
    System.out.println("What is the price of " + itemname);
    double pprice = scan.nextDouble();
    Item pitem = new Item(itemname, pamount, pprice);
    return pitem;
  }

  public String transaction() {
    Scanner scan = new Scanner(System.in);
    int select = scan.nextInt();
    while (select <= 0 || select > inventory.size()) {
      System.out.println("Please type a valid item number.");
    }
    if (inventory.get(select - 1).getAmount() <= 0) {
      return "The item is sold out!";
    }
    System.out.println("How many dollars are you going to use?");
    int rdoll = scan.nextInt();
    System.out.println("How many quarters are you going to use?");
    int rquart = scan.nextInt();
    while (rdoll <= 0 && rquart <= 0) {
      System.out.println("Please insert valid Cash.");
    }
    double cash = (rdoll + (rquart * .25));
    double change = cash - inventory.get(select - 1).getPrice();
    double tempchange = change;
    System.out.println("What would you like to do with the money?");
    System.out.println("1: Buy the Item\n2: Get money back");
    int hek = scan.nextInt();
    while (hek > 2 || hek < 1) {
      System.out.println("Please type a valid item number.");
    }
    if (hek == 1) {
      if (inventory.get(select - 1).getPrice() > cash) {
        return "Not enough money!";
      }
      if (change == 0) {
        return "Item dispensed. Thank you!";
      }
      System.out.println("Dollars in machine: " + dollars + " Quarters in machine: " + quarters);
      if (dollars >= change) {
        double dollarstemp = dollars * 1.00 - change;
        if (quarters - change / .25 < 0) {
          return "Not enough change! Please insert exact amount!";
        } else {
          dollars = (int) dollarstemp;
          inventory.get(select - 1).setAmount(inventory.get(select - 1).getAmount() - 1);
          return "Your Change: " + change;
        }
      }

      dollarstemp = change - dollarstemp * 1.00;
      if (quarters - change / .25 < 0) {
        return "Not enough change! Please insert exact amount!";
      }
      dollars = (int) dollarstemp;
      inventory.get(select - 1).setAmount(inventory.get(select - 1).getAmount() - 1);
      return "Your Change: " + tempchange;

    }
    return "Money returned: " + cash;

  }

  public String toString() {
    String inv = "";
    for (int i = 0; i < inventory.size(); i++) {
      inv += (i + 1) + " Item Name: " + inventory.get(i).getName() + " Item Amount: " + inventory.get(i).getAmount()
          + " Item Price: " + inventory.get(i).getPrice() + "\n";
    }
    return inv;
  }

}
