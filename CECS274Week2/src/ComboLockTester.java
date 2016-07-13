
public class ComboLockTester {

   public static void main(String[] args) {

      ComboLock test = new ComboLock(1,2,3);
      System.out.println(test.getDialPosition());
      test.turnRight(30);
      System.out.println(test.getDialPosition());
      test.turnLeft(10);
      System.out.println(test.getDialPosition());
      
   }

}

/*
0
after ticks decrement -5
after past 0 mark 35
35

ticks can be above 39, such as 100, 200.
 so a math operator to deal with that is using modulus. 
 thanks to Mr. T for the hint

*/

//testing