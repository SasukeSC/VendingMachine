public class Item {
 
 private String name;
 private int amount;
 private double price;
 
 public Item (String pname, int pamount, double pprice) 
 {
  
  name = pname;
  amount = pamount;
  if (pprice % .25 ==0 && pprice>0)
  {
  price = pprice;
  }
  else
  {
    pprice -= (pprice%.25);
    price = pprice;
  }
  
  
 }
 public boolean hasAvailability()
 {
   if (amount>0)
   {
     return true;
   }
   return false;
 }
 
 public String getName () {
  return name;
 }
 
 public int getAmount () {
  return amount;
 }
 
 public double getPrice () {
  return price;
 }
 
 public void setName (String newName) {
  name = newName ;
 }
 
 public void setAmount (int newAmount) {
  amount = newAmount;
 }
 
 public void setPrice (double newPrice) {
  price = newPrice;
 }
 
}





