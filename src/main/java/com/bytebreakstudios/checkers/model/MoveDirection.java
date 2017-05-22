package com.bytebreakstudios.checkers.model;

public enum MoveDirection {
    UPLEFT(-1, -1),
    DOWNLEFT(-1, 1),
    UPRIGHT(1, -1),
    DOWNRIGHT(1, 1);

    private int _x = 0;
    public int x(){return _x;}
    private int _y = 0;
    public int y(){return _y;}
    MoveDirection(int x, int y){
        _x = x;
        _y = y;
    }
}
