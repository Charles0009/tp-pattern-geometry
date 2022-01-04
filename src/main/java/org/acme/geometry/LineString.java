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
    
    public void translate(double dx, double dy) {

        List<Point> points_translated = new ArrayList<>();

        for(Point point : this.points){
            double new_coord_x = dx + point.getCoordinate().getX();
            double new_coord_y = dy + point.getCoordinate().getY();
            Coordinate coord = new Coordinate (new_coord_x, new_coord_y);
            Point new_point = new Point (coord);

            points_translated.add(new_point);
        }
        this.points = points_translated;
    }

    
    public LineString clone(){

        List<Point> newPoints = new ArrayList<>(getNumPoints());
        for(Point point : points){
            newPoints.add(point.clone());
        }
        return new LineString(newPoints);
    }

  


    @Override
    public String getType() {
        return "LINESTRING";
    }

    @Override
    public Envelope getEnvelope() {

        EnvelopeBuilder builder = new EnvelopeBuilder();

        if (isEmpty()) {
            return new Envelope();
        } else {
            for(int i = 0 ; i < getNumPoints() ; i++){
                builder.insert(getPointN(i).getCoordinate());
            }
            return builder.build();
        }
    }

    


}
