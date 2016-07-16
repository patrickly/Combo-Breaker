import java.util.*;
////////////////////////////////////////////////////////////////////////////////
public class ComboProgram {

   public static void main(String[] args) {

      Random generator = new Random();
//      int rng1 = generator.nextInt(40);
//      int rng2 = generator.nextInt(40);
//      int rng3 = generator.nextInt(40);

    int rng1 = 0;
    int rng2 = 14;
    int rng3 = 37;
      
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

         int getDialinit = randomLock.getDialPosition();

         int fullRotation = 40;
         int ticks1 = fullRotation - userC1; 

         randomLock.turnRight(ticks1);

         int getDial1 = randomLock.getDialPosition();

         int ticks2 = userC2 - userC1;
         randomLock.turnLeft(ticks2);

         int ticks3 = 0; 
         ticks3 = (userC3 > userC2 ) ? 40-(userC3-userC2) : userC2-userC3 ;
         randomLock.turnRight(ticks3);

         System.out.println("(1st combo testing secret combination: " + userC1 + 
          " " + userC2 + " " + userC3 + ")");

         if(!(userC1 == 0 && userC2 == 0 && userC3 == 0)){
            if(randomLock.open()) {
               System.out.println("you win");
            }else {
               System.out.println("you lose");
            }
         }
         
         randomLock.reset();
      }
      while(!(userC1 == 0 && userC2 == 0 && userC3 == 0));

   }
}

/*
 * 
 * (Random secret combination: 5 30 29)
Enter combo guess: 5 30 29
(1st combo testing secret combination: 5 30 29)
you lose
Enter combo guess: 5 30 29
(1st combo testing secret combination: 5 30 29)
you lose
Enter combo guess: 



(Random secret combination: 0 14 37)
Enter combo guess: 0 14 37
(1st combo testing secret combination: 0 14 37)
you lose
Enter combo guess: 


So I will manually put 0 14 37 for the randomLock and see what will happen.

(Random secret combination: 0 14 37)
Enter combo guess: 0 14 37
(1st combo testing secret combination: 0 14 37)
you lose
Enter combo guess:  

Strange I still lose. 
*/
