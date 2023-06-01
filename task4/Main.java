
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> numsList = new ArrayList<>();
        try {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                numsList.add(num);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int[] nums = new int[numsList.size()];
        for (int i = 0; i < numsList.size(); i++) {
            nums[i] = numsList.get(i);
        }

        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int steps = 0;
        for (int num : nums) {
            steps += Math.abs(num - median);
        }

        System.out.println(steps);
    }
}