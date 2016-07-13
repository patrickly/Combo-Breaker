
public class ComboLockTester {

   public static void main(String[] args) {

      ComboLock test = new ComboLock(1,2,3);
      System.out.println(test.getDialPosition());
      test.turnRight(1);
      System.out.println(test.getDialPosition());
      test.turnLeft(0);
      System.out.println(test.getDialPosition());
      System.out.println("modulus test: " + 20%40);

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
 
 turnRight(40) should bring the dial back to the same #.
 right now, turnRight(80) gives me -40, which is not intended. should have been 0. maybe turn 80 to 40?
 I might use a while loop. 
 turnRight(41) should be equivalent to turnRight(1)
 Maybe I should use modulus for ticks > 41?
 41 should be 1. 80 should be 40. 40 can actually be 0, since dial ends up in same spot.
 
 
 turnRight(41) 
 starting position: 0
 expected position: 39
 actual position: -1
 
 turnRight(1)
 starting position: 0
 expected position: 39
 actual position: 39
 
 
Using chrome's console, I performed entered these operations: 
80%40
0
41%40
1
120%40
0

20%40 = 20. So ticks value doesn't have be greater than 41. I can just do ticks % 40. 

*/

//testing