package org.acme.geometry;

public class WktWriter {

    public WktWriter(){

    }

    public String write (Geometry geometry){

        if ( geometry instanceof Point ){
            // traiter le cas Point
            Point point = (Point)geometry;

            if(point.isEmpty()){
                return "POINT EMPTY";
            }   
            else {
            return point.getType() + "(" + point.getCoordinate().getX() +" "+point.getCoordinate().getY()+")";
            }
        }else if ( geometry instanceof LineString ){
            // traiter le cas LineString
            LineString lineString = (LineString)geometry;

            if(lineString.isEmpty()){
                return "LINESTRING EMPTY";
            }
            else{
            String str2rtrn = lineString.getType() + "( ";
            
            for(int i = 0 ; i < lineString.getNumPoints() ; i++){
                Coordinate coords = lineString.getPointN(i).getCoordinate();
                str2rtrn += "(" + coords.getX() + " " + coords.getY() + ") ";
            }
            str2rtrn += ")";
            return str2rtrn;
            }
        }else{
            throw new RuntimeException("geometry type not supported");
        }
    }




}
