import java.util.Random;

public class ComboProgram {

   

   //testin

public static void main(String[] args) {
   
   Random generator = new Random();
   int rng1 = generator.nextInt(40);
   int rng2 = generator.nextInt(40);
   int rng3 = generator.nextInt(40);
   ComboLock randomLock = new ComboLock(rng1, rng2, rng3);

   System.out.println("(Random secret combination: " + rng1 + 
    " " + rng2 + " " + rng3 + ")");
 
   
  

  }
}
   

