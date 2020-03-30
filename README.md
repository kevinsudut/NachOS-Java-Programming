# How to running NachOS program
---

### Step 1 until 4 are the preparation step

Step 1
------
![step 1](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/1.PNG)
1. Create new project using your eclipse
2. Copy nachos folder to src folder. Click [here](https://github.com/kevinsudut/NachOS-Java-Programming) to download or clone nachos project

Step 2
------
![step 2](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/2.PNG)
1. For this documentation, I using package proj1 and first of all please create a new java class which the name is MainSystem.java
2. Copy the following code to your MainSystem.java file

```java
package nachos.proj1;

public class MainSystem {

	public MainSystem() {
		System.out.println("\nFOO!!!\n");
	}

}
```

Step 3
------
![step 3](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/3.PNG)
1. Open nachos.conf file inside proj1
2. For proj1 using ThreadedKernel class inside nachos.threads package 

Step 4
------
![step 4](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/4.PNG)
1. Open ThreadedKernel.java inside nachos.threads package
2. Find run() method in the source file and inside the method create new MainSystem object. Don't forget to import MainSystem class because the class is in a different package

```java
import nachos.proj1.MainSystem;
```

```java
public void run() {
    new MainSystem();
}
```

### Step 5 until 11 are the step for running the project

Step 5
------
![step 5](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/5.png)
1. Click Run symbol in the menu bar
2. Click Run Configurations...

Step 6
------
![step 6](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/6.PNG)
1. Double click on Java Application
2. Click Search... button until the shown popup new window

Step 7
------
![step 7](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/7.PNG)
1. Choose Machine class inside nachos.machine package because the class contain public static void main method
2. Click Ok button

Step 8
------
![step 8](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/8.PNG)
1. Click Arguments tab
2. Click Other radio button
3. Click Workspace... button untul the shown popup new window

Step 9
------
![step 9](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/9.PNG)
1. Choose your working directory. In this case, choose proj1 folder
2. Click OK button

Step 10
-------
![step 10](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/10.PNG)
1. Make sure the text field fill with your working directory
2. Click Apply button
3. Click Run button

Step 11
-------
![step 11](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/11.PNG)
1. Finally your NachOS project run successfully

### Step 12 until 13 are another step if you choose your MainSystem.java as the kernel

Step 12
-------
![step 12](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/12.PNG)
1. Change the value of Kernel.kernel key with the location of MainSystem.java file. In this case change with nachos.proj1.MainSystem
2. If you want to comment on the old value without remove, you can add # symbol before nachos.threads.ThreadedKernel value

Step 13
-------
![step 13](https://raw.githubusercontent.com/kevinsudut/NachOS-Java-Programming/running_program/images/13.PNG)
1. Extends your MainSystem class with ThreadedKernel class
2. Override the run method and make sure all of the code inside the run method. Assumes the run method like constructor from MainSystem class
3. In the end, follow step 5 until 11 above

Thank you for reading this documentation
