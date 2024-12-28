import java.util.*;

public class ClimbStairs {
    public static void main (String[] args) {
        int stairs = 4;

        System.out.println("There are " + climbStairs(stairs) + " ways to climb " + stairs + " Stairs");
    }

// Behavior: To return how many ways you can climb the user input amount of stairs. 
    public static int climbStairs(int stairs){

// Behavior: If the user input of stairs is 0 or 1 there is only one possible way to climb. 
        if(stairs == 0 || stairs == 1) {
            return 1;
        }

// Behavior: Calculate ways to proceed if person is able to perform one or two steps till stairs 
// user input has achieved. Math formula for caculating ways to climib x number of stairs is below:
//  
// Formula: f(n) = f(n-1)g + f(n-2).
        return climbStairs(stairs - 1) + climbStairs(stairs - 2);
    }
}