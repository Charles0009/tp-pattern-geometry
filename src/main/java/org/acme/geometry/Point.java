package org.acme.geometry;
import java.sql.ResultSet;

public class Point implements Geometry{

    private Coordinate coordinate;

    public Point(){
        this.coordinate = new Coordinate();
    }
    
    public Point(Coordinate coordinate){
        if ( coordinate == null ){
            this.coordinate = new Coordinate();
        }else{
            this.coordinate = coordinate;
        }
    }

    @Override
    public String getType() {
        return "POINT";
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public boolean isEmpty(){
        return this.coordinate.isEmpty();
    }

    public void translate (double dx, double dy){
        if (this.coordinate.isEmpty()) {
            this.coordinate = new Coordinate(dx, dy);
        }
        else{
            double new_coord_x = dx + this.coordinate.getX();
            double new_coord_y = dy + this.coordinate.getY();
            this.coordinate = new Coordinate (new_coord_x, new_coord_y);
        }
    }

    public Point clone(){
        return new Point(this.coordinate);
    }

    public Envelope getEnvelope() {
        if(! isEmpty()){
            return new Envelope(this.coordinate,this.coordinate);
        }        
        return new Envelope();
    }

    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }
    
}
