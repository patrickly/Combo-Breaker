
public class ComboLockTester {

   public static void main(String[] args) {

      // Test #1:  correctly open the lock.  open() should return true. 
      ComboLock c1 = new ComboLock (10, 20, 30);
      c1.turnRight(30); // turn right to position 10.
      c1.turnLeft(10); // turn left to position 20. 
      c1.turnRight(30); // turn right to position 30. 
      System.out.println("Opening lock c1: " + c1.open()); // true
      

      // Test #2:  incorrectly open the lock.  open() should return false.
      // turn the lock right, right, right to the correct numbers.
      ComboLock c2 = new ComboLock (5, 15, 20);
      c2.turnRight(35); // turn right to position 5.
      c2.turnRight(25); // turn right to position 15. 
      c2.turnRight(35); // turn right to position 20. 
      System.out.println("Opening lock c2: " + c2.open()); // false 

      // Test #3:  incorrectly open the lock.  open() should return false. 
      // turn the lock right to the first correct number,
      // then left to a wrong number, then right to a wrong number.
      ComboLock c3 = new ComboLock (7, 34, 3);
      c3.turnRight(33); // turn right to position 7.
      c3.turnLeft(27); // turn left to position 34. 
      c3.turnRight(3); // turn right to position 31. 
      System.out.println("Opening lock c3: " + c3.open()); // false
      
      // Test #4:  incorrectly open the lock.  open() should return false. 
      // turn the lock right to a wrong number,
      // then left to a wrong number, then right to the correct number.
      ComboLock c4 = new ComboLock (27, 13, 10);
      c4.turnRight(14); // turn right to position 26.
      c4.turnLeft(26); // turn left to position 12. 
      c4.turnRight(2); // turn right to position 10. 
      System.out.println("Opening lock c4: " + c4.open()); // false
      
      // Test #5:  correctly open the lock, but call reset().
      // open() should return false. 
      ComboLock c5 = new ComboLock (25, 6, 15);
      c5.turnRight(15); // turn right to position 25.
      c5.turnLeft(21); // turn left to position 6. 
      c5.turnRight(31); // turn right to position 15. 
      c5.reset(); // reset to position 0. 
      System.out.println("Opening lock c5: " + c5.open()); // false
      
   }

}



