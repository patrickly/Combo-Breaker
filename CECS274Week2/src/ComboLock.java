////////////////////////////////////////////////////////////////////////////////
/**
 * Represents a combination lock with members for the combinations, 
 * dial position, user's combinations, spin directions, and amount of turns. 
 */   

public class ComboLock {

	private int mCombo1;
	private int mCombo2;
	private int mCombo3;
	private int mDial;
	
	private int mFirstSpinCombo;
	private int mSecondSpinCombo;
	private int mLastSpinCombo;

	private String mSpinLeft;
	private String mSpinRight;
	
	private String mSpinDirection1;
	private String mSpinDirection2;
	private String mSpinDirection3;
	
	private int mAmountOfTurns;


	/**
	 * Constructs a ComboLock object that takes three values
	 * for the lock's combination.
	 *
	 * @param combo1 Enter an integer value for the range: 0-39
	 * @param combo2 Enter an integer values for the range: 0-39
	 * @param combo3 Enter an integer values for the range: 0-39
	 */
	public ComboLock(int combo1, int combo2, int combo3) {
	   
		mCombo1 = combo1;
		mCombo2 = combo2;
		mCombo3 = combo3;
		mDial = 0;
	
	}
	
	/**
	 * Gets the current dial position of the lock.
	 *  
	 * @return an Integer for the dial position.
	 */
	public int getDialPosition() {
	   return mDial; 
	}
	
	/**
	 * Reset the dial position back to 0
	 * and starts the unlocking procedure over again
	 */
	public void reset() {
	   mDial = 0;
	   mFirstSpinCombo = 0;
	   mSecondSpinCombo = 0;
	   mLastSpinCombo = 0;
	   mAmountOfTurns = 0;
	}
	
	/**
	 * Turn the dial to left by the specified number of ticks
	 * from the current position
	 * 
	 * @param ticks the integer value for turning the lock 
	 */
	public void turnLeft(int ticks) {
	   mAmountOfTurns++;
	   mSpinLeft = "left";

	   int maxDialValue = 39;
	   int fullRotation = 40;
	   ticks = ticks % fullRotation;
	   
	   mDial += ticks; 
      if(mDial > maxDialValue) { 
         mDial = -(fullRotation - mDial) ; 
      }
         
	      
      if (mAmountOfTurns == 1) {
         mSpinDirection1 = mSpinLeft;
         mFirstSpinCombo = mDial;
      } 
      if (mAmountOfTurns == 2) {
         mSpinDirection2 = mSpinLeft;
         mSecondSpinCombo = mDial;
      } 
      if (mAmountOfTurns == 3) {
         mSpinDirection3 = mSpinLeft;
         mLastSpinCombo = mDial;
      }    
	}
	
	
	/**
    * Turn the dial to right by the specified number of ticks
    * from the current position
    * 
    * @param ticks the integer value for turning the lock 
    */
	public void turnRight(int ticks) {
	   mAmountOfTurns++;
	   mSpinRight = "right";
	    
	   int minDialValue = 39;
	   int fullRotation = 40;
	   ticks = ticks % fullRotation;
     
      mDial -= ticks;
      System.out.println("mAmountOfTurns: " + mAmountOfTurns); 
      System.out.println("mDial is " + mDial ) ;
      if(mDial < minDialValue) {
         
         mDial = fullRotation + mDial;
         
         System.out.println("mDialPis " + mDial ) ;
         if(mDial>minDialValue){
            mDial -= fullRotation;
            System.out.println("mDialMinus " + mDial);
         }
      }
     
    
      if (mAmountOfTurns == 1) {
         mSpinDirection1 = mSpinRight;
         mFirstSpinCombo = mDial;
      } 
      if (mAmountOfTurns == 2) {
         mSpinDirection2 = mSpinRight;
         mSecondSpinCombo = mDial;
      }  
      if (mAmountOfTurns == 3) {
         mSpinDirection3 = mSpinRight;
         mLastSpinCombo = mDial;
      } 
   }
	
	/**
	 * Opens the lock
	 * 
	 * @return a Boolean for the outcome of opening the lock.
	 */
	public boolean open() {
	   
	   System.out.println("mCombo1 "+ mCombo1);
	   System.out.println("mCombo2 "+ mCombo2);
	   System.out.println("mCombo3 "+ mCombo3);

	   System.out.println("mFirstSpinCombo "+ mFirstSpinCombo);
	   System.out.println("mSecondSpinCombo "+ mSecondSpinCombo);
	   System.out.println("mLastSpinCombo "+ mLastSpinCombo);

	   System.out.println("mSpinDirection1 "+ mSpinDirection1);
	   System.out.println("mSpinDirection2 "+ mSpinDirection2);
	   System.out.println("mSpinDirection3 "+ mSpinDirection3);

	   System.out.println("mSpinRight "+ mSpinRight);
	   
	   if(mCombo1 == mFirstSpinCombo && mCombo2 == mSecondSpinCombo
	    && mCombo3 == mLastSpinCombo && mSpinDirection1 == mSpinRight
	    && mSpinDirection2 == mSpinLeft && mSpinDirection3 == mSpinRight) {
	      reset();
	      return true;
	   }
	   else{
	      reset();
	      return false;
	   }
	}
	
}
