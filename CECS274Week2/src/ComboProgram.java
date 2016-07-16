import java.util.*;

public class ComboProgram {

   


public static void main(String[] args) {
   
   Random generator = new Random();
   int rng1 = generator.nextInt(40);
   int rng2 = generator.nextInt(40);
   int rng3 = generator.nextInt(40);
   int ex = 10, ex2 = 13, ex3 = 20;
   
   ComboLock randomLock = new ComboLock(rng1, rng2, rng3);
   
   System.out.println("(Random secret combination: " + rng1 + 
         " " + rng2 + " " + rng3 + ")");
   
   do{
      
      
   Scanner in = new Scanner(System.in);
   System.out.print("Enter combo guess: ");
   String[] userInput = in.nextLine().split(" ");
   ex = Integer.parseInt(userInput[0]);
   ex2 = Integer.parseInt(userInput[1]);
   ex3 = Integer.parseInt(userInput[2]);
   
   System.out.println(ex + " " + ex2 + " " + ex3 + " ");
   

      
   
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
  
  
  int ticks3 = 0;  // goal is to get ticks3 to equal 26, when ex is 10, ex2 is 13, and when ex3 is 27.
  // 13+26 = 39.    27-26 = 1.    13-(13) = 0.   0-(10) = 30.   30-(3) = 27.  (13)+(10)+(3) = 26. added these parentheses and got 26.
  // Anytime the dial goes pass 0 or 39, I must write the appropriate code. 13-(13) = 0. I passed 0 when 0-(10) = 30. 
  // So to go from 13 to 27, I need to turn right 26 ticks. Hmm...13-13 = 0.  So I need 13 more ticks to get to 27.  X-13 = 27. So 40-13 = 27. x = 27+13 = 40
  // Guess I got to use 40 whenever the ticks passes 0. 
  //  40 - 13 = 27.    40 -  13 = ex3.   
  //  2nd Dial position is at 13.  So when ex3 is greater than 2nd dial position, 27 > 13, perform fullRotation minus 2nd Dial Position and then add 2ndDial Position
  //  So 27 > 13, 13-13 = 0. ticks3 += 13. Then 40-13 = 27. ticks3 += 13. ticks3 is now 26 cuz of 13 + 13. 
  //ticks3 = (ex3 > ex2 ) ? ex2-ex2+ex2 : ex2-ex3 ;   // expression 2 or false value is currently . true condition expression 1 is ex3-ex2+ex2. so ticks3 = expression1 whenever ex3 > ex2. 
  // when ex3 < ex2, the expression 2 can be fullRotation - ex2. ex. 12 < 13. ex3 is 12, ex2 is 13.  so ticks3 = ex2-ex3. ticks3 should be 1 when ex2 is 13 and ex3 is 12.
  
  // gonna use if operator instead of ternary operator since ex3 = 27 didn't give the right result for the ternary just above.
  
  /*
  if (ex3>ex2) {
     ticks3 = 40 - (ex3-ex2);  // 40 is full-rotation
     
  } else {
     ticks3 = ex2 - ex3; 
  }
  */
  
  // I can probably use the ternary operator again. Instead of ex2-ex2+ex2. <---I probably got confused.It might be 40-(ex3-ex2) whenever ex3>ex2. 
  // I came up with 40-(ex3-ex2) when I made ex3 = 15 because I know turnRight(38) will give 15. Obviously turnRight(40), a full Rotation, will give 13.
  // So subtract ex2 from ex3 first, then subtract from 40, notice the parenthesis. 
  ticks3 = (ex3 > ex2 ) ? 40-(ex3-ex2) : ex2-ex3 ;
  
  randomLock.turnRight(ticks3);
  System.out.println("\n\n----\n get 3rd dial position " + randomLock.getDialPosition());

  
  
   System.out.println("(Random secret combination: " + rng1 + 
    " " + rng2 + " " + rng3 + ")");
 
   
  
  
  System.out.println("(1st combo testing secret combination: " + ex + 
   " " + ex2 + " " + ex3 + ")");
  
  if(randomLock.open()){
     System.out.println("Congrats you have won free concert tickets.");
  }else{
     System.out.println("Sorry not a winner.");
  }
  
   }
   while(!(ex == 0 && ex2 == 0 && ex3 == 0));
  
   

  }
}
   

/*
 * 
 * (Random secret combination: 1 15 16)
Enter combo guess: 1 15 16
1 15 16 
get initial dial position 0

----
The amount of turn is 1
The amount of turn is/are: 1
The value of ticks modolo 40 is 39
after ticks decrement -39
after past 0 mark 1


----
 get 1st dial position 1
The value of ticks modolo 40 is 14
after ticks decrement 15
after past 0 mark 15


----
 get 2nd dial position 15
The amount of turn is 3
The amount of turn is/are: 3
The value of ticks modolo 40 is 39
after ticks decrement -24
after past 0 mark 16


----
 get 3rd dial position 16
(Random secret combination: 1 15 16)
(1st combo testing secret combination: 1 15 16)

Congrats you have won free concert tickets.
Enter combo guess: 0 0 0
0 0 0 
get initial dial position 16

----
The amount of turn is 4
The amount of turn is/are: 4
The value of ticks modolo 40 is 0
after ticks decrement 16
after past 0 mark 16


----
 get 1st dial position 16
The value of ticks modolo 40 is 0
after ticks decrement 16
after past 0 mark 16


----
 get 2nd dial position 16
The amount of turn is 6
The amount of turn is/are: 6
The value of ticks modolo 40 is 0
after ticks decrement 16
after past 0 mark 16


----
 get 3rd dial position 16
(Random secret combination: 1 15 16)
(1st combo testing secret combination: 0 0 0)

Congrats you have won free concert tickets.

 * 
 */

