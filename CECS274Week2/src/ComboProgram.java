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
  randomLock.turnRight(ticks3);
  System.out.println("\n\n----\n get 3rd dial position " + randomLock.getDialPosition());

  
  /*
   System.out.println("(Random secret combination: " + rng1 + 
    " " + rng2 + " " + rng3 + ")");
 
   */
  
  
  System.out.println("(1st combo testing secret combination: " + ex + 
   " " + ex2 + " " + ex3 + ")");

  

  }
}
   

