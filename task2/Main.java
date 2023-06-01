import java.awt.*;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point2D.Float> points = new ArrayList<>();
        String file = args[0];
        String file2 = args[1];
        float x0=0;
        float y0=0;
        float r0 = 0;
        try {
            Scanner scanner = new Scanner(new File(file));
            x0 = scanner.nextFloat();
            y0 = scanner.nextFloat();
            r0 = scanner.nextFloat();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return;
        }
        int count = 0;
        float x = 0;
        float y = 0;
        try {
            Scanner scanner = new Scanner(new File(file2));
            while(scanner.hasNextFloat())
            {
                count += 1;
                if (count % 2 != 0) {
                    x = scanner.nextFloat();
                }
                if (count % 2 == 0) {
                    y = scanner.nextFloat();
                    points.add(new Point2D.Float(x,y));
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File2 not found");
            return;
        }
        Point2D.Float current_point;
        for (int i = 0; i < points.size(); i++) {
            current_point = points.get(i);
            if ((current_point.x - x0)*(current_point.x - x0) + (current_point.y - y0)*(current_point.y - y0) == r0*r0){
                System.out.println(0);
            } else if ((current_point.x - x0)*(current_point.x - x0) + (current_point.y - y0)*(current_point.y - y0) < r0*r0) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}