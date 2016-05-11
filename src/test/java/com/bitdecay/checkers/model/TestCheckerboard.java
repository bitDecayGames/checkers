package com.bitdecay.checkers.model;

import org.junit.Assert;
import org.junit.Test;

public class TestCheckerboard {

    @Test
    public void testCheckerboardSerialization(){
        Checkerboard a = new Checkerboard(8);
        a.getPieceAt(0, 0).get().y = 2;
        Checkerboard b = new Checkerboard(8);
        b.deserialize(a.serialize());
        System.out.println(a);
        Assert.assertEquals(a.serialize(), b.serialize());
    }
}
