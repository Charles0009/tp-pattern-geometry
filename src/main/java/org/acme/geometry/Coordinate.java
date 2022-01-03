package org.acme.geometry;

public class Coordinate {

    private double x = Double.NaN;
    private double y = Double.NaN; 

    public Coordinate(){

    }

    public Coordinate(double x, double y){
        this.x = x;
        this.y = y; 
    }

    public double getX() {
        return x; 
    }

    public double getY() {
        return y; 
    }

    public boolean isEmpty(){
        return(Double.isNaN(this.x) || Double.isNaN(this.x));
    }

}
