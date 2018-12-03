import java.util.Scanner;
import java.util.ArrayList;

public class VendingMachineApplication {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("How many quarters would you like to add to the machine?");
    int pquart = scan.nextInt();
    System.out.println("How many dollars would you like to add to the machine?");
    int pdoll = scan.nextInt();
    VendingMachine yourmachine = new VendingMachine(pquart, pdoll);
    yourmachine.fillmachine(yourmachine.createItem());
    int citem = 1;
    while (citem != 0) {
      System.out.println("Would you like to add another item to the machine?");
      System.out.println("1: Yes\n0: No");
      citem = scan.nextInt();
      if (citem == 0) {
        break;
      }
      yourmachine.fillmachine(yourmachine.createItem());
    }
    System.out.println("Vending Machine Creation Success!");

    int userinput = 1;
    while (userinput != 0) {
      System.out.println("What would you like to do with the machine?");
      System.out.println("1: Buy an item\n2: Fill the machine\n0: Quit");
      userinput = scan.nextInt();
      if (userinput == 1) {
        System.out.println("Please select an item.");
      System.out.println(yourmachine.toString());
        System.out.println(yourmachine.transaction());
      }
      if (userinput==2){
        System.out.println("How many quarters would you like to add to the machine?");
        int equart = scan.nextInt();
        System.out.println("How many dollars would you like to add to the machine?");
        int edoll = scan.nextInt();
        Item temp = yourmachine.createItem();
        System.out.println(yourmachine.fillmachine(temp, edoll, equart));
        System.out.println(yourmachine);
      }
      if(userinput >2 || userinput < 0)
      {
        System.out.println("Please type a valid number.");
      }
    }
    System.out.println("Thanks for Shopping!");

  }

}