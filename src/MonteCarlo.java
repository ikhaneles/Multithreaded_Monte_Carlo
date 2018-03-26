import java.util.Scanner;

public class MonteCarlo {
    static Scanner reader = new Scanner(System.in);
    static int pointsMultiple;
    public static void main(String args[]) {

        setBounds();
        setPointsMultiple();

        System.out.println("Area approximation is processing...");
        Thread[] threadArray = new Thread[4];

        for (int j = 0; j < pointsMultiple; j++) {
            for (int i = 0; i <= 3; i++) {
                CoordinateAdder c1 = new CoordinateAdder();
                threadArray[i] = new Thread(c1);
                threadArray[i].start();
            }

            try {
                for (Thread thread : threadArray) {
                    thread.join();
                }
            } catch (Exception e) {System.out.println(e); }
        }
    System.out.println(AreaGenerator.getArea());
    }

    private static void setBounds(){

        System.out.println("Please enter the left bound (minimum x value of interest for calculating area).");
        Coordinate.setX_min(reader.nextFloat());
        System.out.println("Please enter the right bound (maximum x value of interest for calculating area).");
        Coordinate.setX_max(reader.nextFloat());
        System.out.println("Please enter the lower bound (minimum y value that your function will have for the entered x bounds).");
        Coordinate.setY_min(reader.nextFloat());
        System.out.println("Please enter the upper bound (maximum y value that your function will have for the entered x bounds).");
        Coordinate.setY_max(reader.nextFloat());

    }

    private static void setPointsMultiple(){
        System.out.println("Please set you points multiple. More points makes answers more accurate." +
                " Please note, the number you enter will be multiplied by 4. (try entering 1000," +
                " 10000, etc to see how the algorithm performs.)");

        pointsMultiple = reader.nextInt();
    }

}
