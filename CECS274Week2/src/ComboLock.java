
public class ComboLock {

	
	private int mCombo1;
	private int mCombo2;
	private int mCombo3;
	private int mDial;
	
	/**
	 * Later, I'm going to add member variables for the boolean open method.
	 */
	private int mFirstSpinCombo;
	private int mSecondSpinCombo;
	private int mLastSpinCombo;

	private String mSpinDirection;
	private String mSpinLeft = "left";
	private String mSpinRight = "right";
	
	private String mSpinDirection1;
	private String mSpinDirection2;
	private String mSpinDirection3;
	
	private int mAmountOfTurns;



	/**
	 *Constructor 
	 *
	 * @param combo1 Enter integer values for the range: 0-39
	 * @param combo2 Enter integer values for the range: 0-39
	 * @param combo3 Enter integer values for the range: 0-39
	 */
	public ComboLock(int combo1, int combo2,
	 int combo3) {
	   
		mCombo1 = combo1;
		mCombo2 = combo2;
		mCombo3 = combo3;
		mDial = 0;
	
	}
	
	/**
	 * 
	 * @return mDial Returns the current dial position of the lock
	 */
	public int getDialPosition() {
	   return mDial; 
	}
	
	/**
	 * Reset() Sets the dial position back to 0 
	 * and start the unlocking procedure over again
	 */
	public void reset() {
	   mDial = 0;
	}
	
	/**
	 * 
	 * @param ticks Enter an integer value 
	 */
	public void turnLeft(int ticks) {
	   mAmountOfTurns++;
	   if (mAmountOfTurns == 1) {
         mSpinDirection1 = mSpinLeft;
      } else if (mAmountOfTurns == 2){
         mSpinDirection2 = mSpinLeft;
      } else if (mAmountOfTurns == 3){
         mSpinDirection3 = mSpinLeft;
      } else {
         System.out.println("mAmountOfTurns is not 1, 2, nor 3");
      }  System.out.println("The amount of turn is/are: " + mAmountOfTurns);

   
	   int fullRotation = 40;

	   ticks = ticks % fullRotation;
	   System.out.println("The value of ticks modolo 40 is " + ticks);
	   
	   mDial += ticks; 
	      System.out.println("after ticks decrement " + mDial);

	      System.out.println("after past 0 mark " + mDial);
	         
	        
	}
	
	
	/**
    * 
    * @param ticks Enter an integer value 
    */
	public void turnRight(int ticks) {
	   mAmountOfTurns++;
	   
	   
	   System.out.println("The amount of turn is " + mAmountOfTurns);


	   if (mAmountOfTurns == 1) {
	      mSpinDirection1 = mSpinRight;
	   } else if (mAmountOfTurns == 2){
	      mSpinDirection2 = mSpinRight;
	   } else if (mAmountOfTurns == 3){
	      mSpinDirection3 = mSpinRight;
	   } else {
	      System.out.println("mAmountOfTurns is not 1, 2, nor 3");
	   }
    //  mSpinDirection2 = (mAmountOfTurns == 2) ? mSpinRight : mSpinLeft;
   //   mSpinDirection3 = (mAmountOfTurns == 3) ? mSpinRight : mSpinLeft;

      System.out.println("The amount of turn is/are: " + mAmountOfTurns);
	   int fullRotation = 40;
	   ticks = ticks % fullRotation;
      System.out.println("The value of ticks modolo 40 is " + ticks);

      mDial -= ticks;
      System.out.println("after ticks decrement " + mDial);

      if(mDial < 0) {
         mDial = fullRotation + mDial; // 40 is a magic number. 40 is a full-spin tick. 
      }
      System.out.println("after past 0 mark " + mDial);
         
        
      }
	
	public int getAmountOfTurns() {
	   return mAmountOfTurns;
	}
	
	public String getTurn1() {
	   return mSpinDirection1;
	}
	
   public String getTurn2() {
      return mSpinDirection2;

      }
   
   
   public String getTurn3() {
      return mSpinDirection3;

   }
      
   
	
	public boolean open() {
	   
	   
	   return false;
	}
	
}
