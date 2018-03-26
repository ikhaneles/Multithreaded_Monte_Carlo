public class CoordinateAdder implements Runnable {

    public void run(){
        Coordinate coordinate = Coordinate.generateCoordinate();
        AreaGenerator.addPoint(coordinate);

        //coordinate.printCoordinate();
    }
}
