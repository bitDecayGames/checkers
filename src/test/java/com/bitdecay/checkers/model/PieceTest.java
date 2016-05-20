package com.bitdecay.checkers.model;

import org.junit.Assert;
import org.junit.Test;

public class PieceTest {

    @Test
    public void testPieceSerialization(){
        Piece a = new Piece();
        Piece b = new Piece();

        a.id = 2;
        System.out.println(a);
        b.deserialize(a.serialize());
        Assert.assertTrue(eq(a, b));

        a.team = Team.BLACK;
        System.out.println(a);
        b.deserialize(a.serialize());
        Assert.assertTrue(eq(a, b));

        a.king = true;
        System.out.println(a);
        b.deserialize(a.serialize());
        Assert.assertTrue(eq(a, b));
    }

    private boolean eq(Piece a, Piece b){ return a.id == b.id && a.team == b.team && a.king == b.king; }
}
