import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = "";
        int n;
        int m;
        try {
            n = Integer.parseInt(args[0]);
            if (n<=1) {
                System.out.println("Error, next put n by the terms, must be > 1");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error, next put n by the terms, must be int ");
            return;
        }
        try {
            m = Integer.parseInt(args[1]);
            if (m<=1) {
                System.out.println("Error, next put m by the terms, must be > 1");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error, next put m by the terms, must be int ");
            return;
        }

        int[] array = new int[n];
        for (int i=0;i<n;i++){
            array[i] = i + 1;
        }
        int first_element = array[0];
        int first_el_dynamic;
        int last_el_of_subarray = -100;
        int index_last;
        int index_start = 0;
        while (first_element != last_el_of_subarray){
            index_last =  index_start + m - 1;
            while (index_last >= array.length) {
                index_last = index_last - array.length;
            }
            last_el_of_subarray = array[index_last];
            first_el_dynamic = array[index_start];
            path += String.valueOf(first_el_dynamic);
            index_start = index_last;
        }
        System.out.println(path);
    }
}