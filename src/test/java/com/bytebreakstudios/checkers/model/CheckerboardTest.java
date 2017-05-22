package com.bytebreakstudios.checkers.model;

import org.junit.Assert;
import org.junit.Test;

public class CheckerboardTest {

    // TODO: implement the deserialize method for the checkerboard
    // @Test
    public void testCheckerboardSerialization(){
        Checkerboard a = new Checkerboard(8);
        Checkerboard b = new Checkerboard(8);
        b.deserialize(a.serialize());
        System.out.println(a);
        Assert.assertEquals(a.serialize(), b.serialize());
    }

    @Test
    public void testCheckerboardConstructionOdd(){
        try {
            Checkerboard a = new Checkerboard(9);
        } catch(Exception e) {
            Assert.assertTrue("Expected error to be about odd sized board", e.getMessage().contains("even"));
            return;
        }
        Assert.fail("Expected checkboard to throw error on odd sized board");
    }

    @Test
    public void testCheckerboardConstructionSmall(){
        try {
            Checkerboard a = new Checkerboard(2);
        } catch(Exception e) {
            Assert.assertTrue("Expected error to be about board too small", e.getMessage().contains("6x6"));
            return;
        }
        Assert.fail("Expected checkboard to throw error on small board size");
    }
}
