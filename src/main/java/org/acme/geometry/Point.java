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
        return "Point";
    }

    public Coordinate getCoordinate(){
        return this.coordinate;
    }

    public boolean isEmpty(){
        return this.coordinate.isEmpty();
    }

    public void translate (Double dx, Double dy){
        if (this.coordinate.isEmpty()) {
            this.coordinate = new Coordinate(dx, dy);
        }
        else{
            Double new_coord_x = dx + this.coordinate.getX();
            Double new_coord_y = dy + this.coordinate.getY();
            this.coordinate = new Coordinate (new_coord_x, new_coord_y);
        }
    }

    public Point clone(){
        return new Point(this.coordinate);
    }
    
}
