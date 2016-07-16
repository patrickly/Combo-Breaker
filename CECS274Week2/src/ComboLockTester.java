
public class ComboLockTester {

   public static void main(String[] args) {

      // Test #1:  correctly open the lock.  open() should return true. 
      ComboLock c1 = new ComboLock (10, 20, 30);
      c1.turnRight(30); // turn right to position 10.
      c1.turnLeft(10); // turn left to position 20. 
      c1.turnRight(30); // turn right to position 30. 
      System.out.println("Opening lock c1: " + c1.open()); // should output "true" 


      
      
      
   }

}



