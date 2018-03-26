import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Coordinate {
    private float x;
    private float y;
    private static float x_max;
    private static float y_max;
    private static float x_min;
    private static float y_min;

    private Coordinate(float x_val, float y_val) {
        this.x = x_val;
        this.y = y_val;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static void setX_max(float x_max) {
        Coordinate.x_max = x_max;
    }

    public static void setX_min(float x_min){
        Coordinate.x_min = x_min;
    }

    public static void setY_max(float y_max) {
        Coordinate.y_max = y_max;
    }

    public static void setY_min(float y_min){
        Coordinate.y_min = y_min;
    }

    public static float getX_min() {
        return x_min;
    }

    public static float getX_max() {
        return x_max;
    }

    public static float getY_min() {
        return y_min;
    }

    public static float getY_max() {
        return y_max;
    }

    @NotNull
    public static Coordinate generateCoordinate(){
        Random r = new Random();
        float x_val = x_min + r.nextFloat() * (x_max - x_min);
        float y_val = y_min + r.nextFloat() * (y_max - y_min);
        return new Coordinate(x_val,y_val);
    }

    public void printCoordinate(){
        System.out.print("{" + x + "," + y + "}");
    }
}
