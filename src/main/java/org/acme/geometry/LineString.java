package org.acme.geometry;
import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
    
    private List<Point> points;    

    public LineString(){
        this.points = new ArrayList<>();
    }

    public LineString( List<Point> points){
        if ( points == null ){
            this.points = new ArrayList<>();
        }else{
            this.points = points;
        }
    }

    public int getNumPoints(){
        return points.size();
    }

    public Point getPointN(int n){
        return points.get(n);
    }


    public boolean isEmpty(){
        return this.points.isEmpty();
    }
    
    public void translate(Double dx, Double dy) {

        List<Point> points_translated = new ArrayList<>();

        for(Point point : this.points){
            Double new_coord_x = dx + point.getCoordinate().getX();
            Double new_coord_y = dy + point.getCoordinate().getY();
            Coordinate coord = new Coordinate (new_coord_x, new_coord_y);
            Point new_point = new Point (coord);

            points_translated.add(new_point);
        }
        this.points = points_translated;
    }

    
    public LineString clone(){
        return new LineString(this.points);
    }

  


    @Override
    public String getType() {
        return "LineString";
    }

    


}
