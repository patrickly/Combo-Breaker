import java.util.*;

public class ComboProgram {

   public static void main(String[] args) {

      Random generator = new Random();
      int rng1 = generator.nextInt(40);
      int rng2 = generator.nextInt(40);
      int rng3 = generator.nextInt(40);
    
      int userC1, userC2, userC3;

      ComboLock randomLock = new ComboLock(rng1, rng2, rng3);

      System.out.println("(Random secret combination: " + rng1 + 
            " " + rng2 + " " + rng3 + ")");

      do{

         Scanner in = new Scanner(System.in);
         System.out.print("Enter combo guess: ");
         String[] userInput = in.nextLine().split(" ");
         userC1 = Integer.parseInt(userInput[0]);
         userC2 = Integer.parseInt(userInput[1]);
         userC3 = Integer.parseInt(userInput[2]);

         int fullRotation = 40;
         
         int ticks1 = fullRotation - userC1; 
         randomLock.turnRight(ticks1);

         int ticks2 = userC2 - userC1;
         randomLock.turnLeft(ticks2);

         int ticks3 = 0; 
         ticks3 = (userC3 > userC2 ) ? fullRotation-(userC3-userC2): 
          userC2-userC3;
         randomLock.turnRight(ticks3);

         System.out.println("(1st combo testing secret combination: " + userC1 
          + " " + userC2 + " " + userC3 + ")");

         if(!(userC1 == 0 && userC2 == 0 && userC3 == 0)) {
            if(randomLock.open()) {
               System.out.println("Correct! You have won free coupons.");
            }else {
               System.out.println("Sorry, that is incorrect!");
            }
         }
        
      }
      while(!(userC1 == 0 && userC2 == 0 && userC3 == 0));

   }
}


