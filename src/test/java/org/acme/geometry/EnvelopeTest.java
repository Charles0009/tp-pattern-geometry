package org.acme.geometry;
import org.junit.Assert;
import org.junit.Test;

public class EnvelopeTest {

	public static final double EPSILON = 1.0e-15;


	@Test
	public void testInsertionEtBuild(){
		// TODO
        Envelope env = new Envelope( new Coordinate(0.0,0.0),new Coordinate(1.0,1.0));

        Assert.assertEquals(env.getXmax(), 1.0, EPSILON);
        Assert.assertEquals(env.getYmax(), 1.0, EPSILON);

	}

}
