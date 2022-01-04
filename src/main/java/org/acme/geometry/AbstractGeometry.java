package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
    
    public String asText(){
        WktVisitor visitor = new WktVisitor();
        accept(visitor);
        return visitor.getResult();
    }

    public abstract Geometry clone(); 

}
