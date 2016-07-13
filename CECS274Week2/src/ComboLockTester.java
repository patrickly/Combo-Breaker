
public class ComboLockTester {

   public static void main(String[] args) {

      ComboLock test = new ComboLock(1,2,3);
      System.out.println(test.getDialPosition());
      test.turnRight(5);
      System.out.println(test.getDialPosition());
      
   }

}

/*
0
after ticks decrement -5
after past 0 mark 35
35

*/

//testing