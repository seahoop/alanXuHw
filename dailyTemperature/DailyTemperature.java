import java.util.*;

public class DailyTemperature {

    public static void main (String[] args) {
        int[] temperatures = {23, 24, 25, 21, 19, 22, 26, 23};
        int[] result = dailyTemperature(temperatures);

        for(int x : result) {
            System.out.println(x + ", ");
        }
    }

    public static int[] dailyTemperature(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> record = new Stack<>();

        for(int i = 0; i < n; i++) {
            while(!record.isEmpty() && temperatures[i] > temperatures[record.peek()]) {
                int index = record.pop();
                result[index] = i - index;
            }

            record.push(i);
        }

        return result;
    }
}