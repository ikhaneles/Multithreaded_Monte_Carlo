public class AreaGenerator {
    private static int pointsUnderCurve;
    private static int totalPoints;

    public static float getArea(){
//        System.out.println(pointsUnderCurve);
//        System.out.println(totalPoints);
        return ((float)pointsUnderCurve / (totalPoints)) * ((Coordinate.getX_max() - Coordinate.getX_min())*(Coordinate.getY_max()-Coordinate.getY_min()));
    }

    public static synchronized void addPoint(Coordinate point){
        float yValueOnCurve = MyFunction.runFunction(point.getX());
        float yPointValue = point.getY();
        totalPoints++;
        if(yPointValue <= yValueOnCurve && yValueOnCurve >= 0 && yPointValue >=0){
            pointsUnderCurve++;
        }
        else if(yPointValue >= yValueOnCurve && yValueOnCurve <= 0 && yPointValue <=0){
            pointsUnderCurve--;
        }
    }

    public static int getTotalPoints() {
        return totalPoints;
    }

    public static int getPointsUnderCurve() {
        return pointsUnderCurve;
    }
}
