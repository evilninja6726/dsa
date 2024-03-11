package com.dsagame.pepcoding.graphs;

public class Edges {
    public int s;
    public int d;
    public int w;

    public Edges(int s, int d, int w) {
        this.s = s;
        this.d = d;
        this.w = w;
    }

    @Override
    public String toString() {
        return "Edges{" +
                "s=" + s +
                ", d=" + d +
                ", w=" + w +
                '}';
    }
}
