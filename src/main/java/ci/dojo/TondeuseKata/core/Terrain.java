package ci.dojo.TondeuseKata.core;

public class Terrain {
    private int xMax;
    private int yMax;

    private int xMin = 0;
    private int yMin = 0;

    public Terrain(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }

    public int getxMin() {
        return xMin;
    }

    public void setxMin(int xMin) {
        this.xMin = xMin;
    }

    public int getyMin() {
        return yMin;
    }

    public void setyMin(int yMin) {
        this.yMin = yMin;
    }
}
