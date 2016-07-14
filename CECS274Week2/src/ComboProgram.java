import java.util.Random;

public class ComboProgram {

   

   //testin

public static void main(String[] args) {
   
   Random generator = new Random();
   int rng1 = generator.nextInt(40);
   int rng2 = generator.nextInt(40);
   int rng3 = generator.nextInt(40);
   int ex = 10;
   ComboLock randomLock = new ComboLock(ex, rng2, rng3);
   
   int getDial1 = randomLock.getDialPosition();
 //  int getDial3 = randomLock.getDialPosition();

  System.out.println("get initial dial position " + getDial1 + "\n\n----");
 // int ticks1 = 30; // how to get 30 when ex is 10? 40 +(-10) = 30.    fullRotation is 40. 
  // fullRotation + ex = 40 + 10 = 50. 
  // fullRotation + ex(-1) = 40 - 10 = 30.
  // So to ticks1 = fullRotation + (-1)ex.
  int fullRotation = 40;
  int ticks1 = fullRotation - ex; 
  
  randomLock.turnRight(ticks1);
  
  int getDial2 = randomLock.getDialPosition();

  System.out.println("\n\n----\n get 1st dial position " + getDial2);
  // randomLock.turnLeft();

  /*
   System.out.println("(Random secret combination: " + rng1 + 
    " " + rng2 + " " + rng3 + ")");
 
   */
  
  
  System.out.println("(1st combo testing secret combination: " + ex + 
   " " + rng2 + " " + rng3 + ")");

  

  }
}
   

