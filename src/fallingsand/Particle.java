package fallingsand;

import processing.core.PGraphics;

public class Particle extends Position {
    public static final int SIZE = 2;
    private final PGraphics gfx;

    public void draw() {
        gfx.fill(207, 174, 117);
        gfx.rect(col*SIZE,row*SIZE, SIZE, SIZE);
    }

    public Particle(int row, int col, PGraphics gfx) {
        super(row, col);
        this.gfx = gfx;
    }

    @Override
    public String toString() {
        return "Particle{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }


}
