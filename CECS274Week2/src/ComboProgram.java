import java.util.Random;

public class ComboProgram {

   

   //testin

public static void main(String[] args) {
   
   Random generator = new Random();
   int rng1 = generator.nextInt(40);
   int rng2 = generator.nextInt(40);
   int rng3 = generator.nextInt(40);
   int ex = 10, ex2 = 13, ex3 = 27;
   ComboLock randomLock = new ComboLock(ex, rng2, rng3);
   
   int getDialinit = randomLock.getDialPosition();
 //  int getDial3 = randomLock.getDialPosition();

  System.out.println("get initial dial position " + getDialinit + "\n\n----");
 // int ticks1 = 30; // how to get 30 when ex is 10? 40 +(-10) = 30.    fullRotation is 40. 
  // fullRotation + ex = 40 + 10 = 50. 
  // fullRotation + ex(-1) = 40 - 10 = 30.
  // So to ticks1 = fullRotation + (-1)ex.
  int fullRotation = 40;
  int ticks1 = fullRotation - ex; 
  
  randomLock.turnRight(ticks1);
  
  int getDial1 = randomLock.getDialPosition();

  System.out.println("\n\n----\n get 1st dial position " + getDial1);
  
 // int ticks2 = 3;    // so we want to get 3, when ex is 10, and ex2 is 13. well. 13-10 = 3
  // ex2 - ex = 3.
  int ticks2 = ex2 - ex;
  
  randomLock.turnLeft(ticks2);
  System.out.println("\n\n----\n get 2nd dial position " + randomLock.getDialPosition());
  
  
  int ticks3 = 26;  // goal is to get ticks3 to equal 26, when ex is 10, ex2 is 13, and when ex3 is 27.
  // 13+26 = 39.    27-26 = 1.    13-(13) = 0.   0-(10) = 30.   30-(3) = 27.  (13)+(10)+(3) = 26. added these parentheses and got 26.
  // Anytime the dial goes pass 0 or 39, I must write the appropriate code. 13-(13) = 0. I passed 0 when 0-(10) = 30. 
  // So to go from 13 to 27, I need to turn right 26 ticks. Hmm...13-13 = 0.  So I need 13 more ticks to get to 27.  X-13 = 27. So 40-13 = 27. x = 27+13 = 40
  // Guess I got to use 40 whenever the ticks passes 0. 
  //  40 - 13 = 27.    40 -  13 = ex3.   
  //  2nd Dial position is at 13.  So when ex3 is greater than 2nd dial position, 27 > 13, perform fullRotation minus 2nd Dial Position and then add 2ndDial Position
  //  So 27 > 13, 13-13 = 0. ticks3 += 13. Then 40-13 = 27. ticks3 += 13. ticks3 is now 26 cuz of 13 + 13. 
  ticks3 = (ex3 > ex2 ) ? ex3-ex2+ex2 : 0 ;   // expression 2 or false value is currently . true condition expression 1 is ex3-ex2+ex2. so ticks3 = expression1 whenever ex3 > ex2. 
  // when ex3 < ex2, the expression 2 can be fullRotation - ex2. ex. 12 < 13. ex3 is 12, ex2 is 13.  so ticks3 = ex2-ex3. ticks3 should be 1 when ex2 is 13 and ex3 is 12.
  
  
  randomLock.turnRight(1);
  System.out.println("\n\n----\n get 3rd dial position " + randomLock.getDialPosition());

  
  /*
   System.out.println("(Random secret combination: " + rng1 + 
    " " + rng2 + " " + rng3 + ")");
 
   */
  
  
  System.out.println("(1st combo testing secret combination: " + ex + 
   " " + ex2 + " " + ex3 + ")");

  

  }
}
   

