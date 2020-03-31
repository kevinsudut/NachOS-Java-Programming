package nachos.proj1.system;

import nachos.machine.Machine;
import nachos.machine.Timer;

public class MyTimer {

	private Timer timer;
	
	private static MyTimer instance;
	
	private MyTimer() {
		timer = Machine.timer();
	}
	
	/**
	 * Method for get instance from MyTimer class
	 * @return instance from MyTimer class
	 */
	public static synchronized MyTimer getInstance() {
		if (instance == null) {
			instance = new MyTimer();
		}
		return instance;
	}
	
	/**
	 * Get the current time
	 * @return the number of clock ticks since Nachos started
	 */
	public Long getTime() {
		return timer.getTime();
	}
	
	/**
	 * Set the callback to use as a timer interrupt handler
	 * <br>
	 * The timer interrupt handler will be called approximately every 500 clock ticks
	 * @param handler handler the timer interrupt handler
	 */
	public void timerInterrupt(Runnable handler) {
		timer.setInterruptHandler(handler);
	}

}
