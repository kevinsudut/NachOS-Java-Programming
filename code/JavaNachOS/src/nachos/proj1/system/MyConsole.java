package nachos.proj1.system;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

/**
 * This class is using to simulate input and output process using NachOS Serial Console class
 * @author kevinsudut (kevinsuryaw@gmail.com)
 */
public class MyConsole {

	/**
	 * Interface for handler read and write in console
	 */
	private SerialConsole console;
	
	/**
	 * Semaphore to control the process
	 */
	private Semaphore semaphore;
	
	/**
	 * To handler receive data in the interrupt
	 */
	private Runnable receive;
	
	/**
	 * To handler send data in the interrupt
	 */
	private Runnable send;
	
	/**
	 * Temporary variable to store data from input console
	 */
	private Character buffer;
	
	private static MyConsole instance;
	
	private MyConsole() {
		buffer = Character.MIN_VALUE;
		
		receive = new Runnable() {
			
			@Override
			public void run() {
				buffer = (char)console.readByte(); // read input data from the console
				semaphore.V(); // increase semaphore value
			}
		};
		send = new Runnable() {
			
			@Override
			public void run() {
				semaphore.V(); // increase semaphore value
			}
		};
		
		console = Machine.console(); // set console value with StandardConsole object from Machine class
		
		semaphore = new Semaphore(0); // create semaphore object and set initial value is 0
		
		console.setInterruptHandlers(receive, send); // set console interrupt handler read and write data to the console
	}
	
	/**
	 * Method for get instance from MyConsole class
	 * @return instance from MyConsole class
	 */
	public static synchronized MyConsole getInstance() {
		if (instance == null) {
			instance = new MyConsole();
		}
		return instance;
	}
	
	/**
	 * This method to print the data on the console
	 * <br>
	 * Equivalent with <b>System.out.print()</b>
	 * @param str data that will print on the console
	 */
	public void print(Object str) {
		for (Character x : str.toString().toCharArray()) { // loop all data from the parameter
			console.writeByte(x); // write each data to console
			semaphore.P(); // decrease semaphore value. This will trigger send handler (line 52)
		}
	}
	
	/**
	 * This method to print the data on the console and ending with a new line
	 * <br>
	 * Equivalent with <b>System.out.println()</b>
	 * @param str data that will print on the console
	 */
	public void println(Object str) {
		print(str + "\n"); // added data from the parameter with '\n'
	}
	
	/**
	 * This method for reading input data from the console as a string value
	 * @return imputed data from the console
	 */
	public String nextLine() {
		String out = "";
		buffer = Character.MIN_VALUE;
		
		while (buffer != '\n') { // loop until buffer value is '\n' (enter)
			out += buffer; // append out string variable with buffer value
			semaphore.P(); // decrease semaphore value. This will trigger receive handler (line 44)
		}
		
		// return out value from index 1 until the end with trim the value because index 0 is '\u0000' value and that value is not from user input
		return out.substring(1).trim(); 
	}
	
	/**
	 * This method for reading input data from the console as an integer value
	 * @return imputed data from the console
	 */
	public Integer nextInt() {
		try {
			return Integer.parseInt(nextLine()); // parse the input to the integer value
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return Integer.MIN_VALUE; // if the input is not an integer value, then return -2147483648 as the result
	}

}
