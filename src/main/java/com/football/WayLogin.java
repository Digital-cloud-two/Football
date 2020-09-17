package com.football;

public class WayLogin implements Way {
    @Override
    public boolean startWay() {
        System.out.println("WayLogin");
        return true;
    }
}
