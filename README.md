# Serial Console and Timer in NachOS

### Serial Console

Preparation
------------
1. Open nachos.conf file
2. Change the value of Machine.console key with true
```
Machine.console = true
```
3. Write the code for simulate input and output process using NachOS SerialConsole. Click [here](https://github.com/kevinsudut/NachOS-Java-Programming/tree/SerialConsole_Timer/code/JavaNachOS/src/nachos/proj1/system/MyConsole.java) to see the code

Example code
------------
```Java
// get MyConsole instance
MyConsole console = MyConsole.getInstance();

// print without new line
console.print("[*] Call print method");

// print with new line
console.println("[*] Call println method");

// input string value
String string = console.nextLine();

// input integer value
Integer integer = console.nextInt();
```

### Timer

Preparation
-----------
1. Write the code for Timer. Click [here](https://github.com/kevinsudut/NachOS-Java-Programming/tree/SerialConsole_Timer/code/JavaNachOS/src/nachos/proj1/system/MyTimer.java) to see the code

Example code
------------
```Java
// get MyTimer instance
MyTimer timer = MyTimer.getInstance();

timer.timerInterrupt(new Runnable() {
			
    @Override
    public void run() {
        /**
         * This method will run every 500 ticks and only has one in each program.
         * If you create another timer interrupt then will use the last one
         */
    }
});

// get current ticks
console.println("[*] Current ticks " + timer.getTime());
```