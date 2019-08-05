package com.massivecraft.factions.zcore.util;

public class InventoryCoordinateUtil {


    private int x;
    private int y;
    private int rows;

    public InventoryCoordinateUtil(int x, int y, int rows) {
        this.x = x;
        this.y = y;
        this.rows = rows;
    }

    public void increment() {
        if (x == 9) {
            x = 0;
            y++;
        }
    }
}