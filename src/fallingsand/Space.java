package fallingsand;

import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private final List<Particle> particelle;
    private final List<Segment> segmenti;
    private final PGraphics gfx;

    public Space(PGraphics gfx) {
        this.gfx = gfx;
        particelle = new ArrayList<>();
        segmenti = new ArrayList<>();
    }

    public void addSegment(Segment s) {
        segmenti.add(s);
    }

    public void addSegment(Position start, Position end) {
        segmenti.add(new Segment(start,end,gfx));
    }

    public void addParticle(Particle p){
        particelle.add(p);
    }

    public void addParticle(int row, int col){
        particelle.add(new Particle(row,col, gfx));
    }

    public void addParticle(Position pos) {
        addParticle(pos.row,pos.col);
    }

    public void draw() {
        for (var p:particelle) {
            p.draw();
        }
        gfx.fill(20);
        for (var s:segmenti) {
            s.draw();
        }
    }

    public void update() {
        for (var p:particelle) {
            var down = p.getDownPos();
            //boolean collided = isNotFree(down);
            if (!isNotFree(down)) {
                p.moveDown();
            } else {
                if (!isNotFree(p.getLeftDownPos())) {
                    p.moveLeftDown();
                } else {
                    if(!isNotFree(p.getRightDownPos())) {
                        p.moveRightDown();
                    }
                }
            }
        }
    }

    private boolean isNotFree(Position down) {
        var collided = false;
        for(var s:segmenti) {
            if(s.collide(down)) {
                collided = true;
                break;
            }
        }
        for(var p1:particelle) {
            if (p1.row == down.row && p1.col == down.col) {
                collided = true;
            }
        }
        return collided;
    }
}
