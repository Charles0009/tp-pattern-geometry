package org.acme.geometry;

public class WktVisitor implements GeometryVisitor{
    
    private StringBuilder buffer; 

    public WktVisitor(){
        this.buffer = new StringBuilder();
    }


    public void visit(Point point){
        this.buffer.append(point.getType());
        if(point.isEmpty()){
            this.buffer.append("EMPTY");
            return;
        }   
        else {
            this.buffer.append("(" );
            this.buffer.append(point.getCoordinate().getX());
            this.buffer.append(" ");
            this.buffer.append(point.getCoordinate().getY());
            this.buffer.append(")" );
        }
    }

    public void visit(LineString lineString){
        this.buffer.append(lineString.getType());
        if(lineString.isEmpty()){
            this.buffer.append("EMPTY");
            return;
        }   
       
        else{
            this.buffer.append("(" );
        for(int i = 0 ; i < lineString.getNumPoints() ; i++){
            Coordinate coords = lineString.getPointN(i).getCoordinate();
            this.buffer.append("(" );
            this.buffer.append(coords.getX()) ;
            this.buffer.append(" ") ;
            this.buffer.append(coords.getY()) ;
            this.buffer.append( ") ");
        }
        this.buffer.append(")" );
        }
    }

    public String getResult(){
        return this.buffer.toString();
    }




}
