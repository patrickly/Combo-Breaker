
public class ComboLock {
	int x = 2;
	int y = 3;
	
	private int mCombo1;
	private int mCombo2;
	private int mCombo3;
	private int mDial;

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
	public int getDialPosition(){
	   return mDial; 
	}
	
	/**
	 * Reset() Sets the dial position back to 0 
	 * and start the unlocking procedure over again
	 */
	public void reset(){
	   mDial = 0;
	}
	
	public void turnLeft(int ticks){
	   
	}
	
	public void turnRight(int ticks){
      
   }
	
}
