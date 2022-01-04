package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements  GeometryVisitor {

    PrintStream out;

    public LogGeometryVisitor(){
        this.out = System.out;
    }
    public LogGeometryVisitor(PrintStream out){
        this.out = out;
    }

    public void visit(Point point) {
        double x = point.getCoordinate().getX();
        double y = point.getCoordinate().getY();

        this.out.println("Je suis un point avec x=" + x + " et y=" + y );
        
    }


    public void visit(LineString lineString) {
        int size = lineString.getNumPoints();
        this.out.println("Je suis une polyligne définie par "+ size +" point(s)");


    }
    
}
