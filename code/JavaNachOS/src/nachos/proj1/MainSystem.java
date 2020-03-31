package nachos.proj1;

import nachos.proj1.system.MyConsole;
import nachos.proj1.system.MyTimer;
import nachos.threads.ThreadedKernel;

public class MainSystem extends ThreadedKernel {

	Integer counter = 0;
	
	@Override
	public void run() {		
		MyConsole console = MyConsole.getInstance();
		MyTimer timer = MyTimer.getInstance();
	
		timer.timerInterrupt(new Runnable() {
			
			@Override
			public void run() {
				/**
				 * This method will run every 500 ticks and only has one in each program.
				 * If you create another timer interrupt then will use the last one
				 */
				counter++;
			}
		});

		console.println("");
		
		console.println("[*] Hello Wolrd!");
		
		console.println("");
		
		console.print("Input string value: ");
		String string = console.nextLine();
		
		console.print("Input integer value: ");
		Integer integer = console.nextInt();
		
		console.println("\n");
		
		console.println("[+] Result input string value \t: " + string);
		console.println("[+] Result input integer value \t: " + integer);
		
		console.println("\n");
		
		console.println("[*] Current ticks " + timer.getTime());
		console.println("[*] The timer interrupt call " + counter + " times");
	}

}
