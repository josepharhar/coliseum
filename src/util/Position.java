package util;

public class Position {
    public double x;
    public double y;
    
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }
    
    public static double distance(Position a, Position b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}
