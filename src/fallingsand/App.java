package fallingsand;

import processing.core.PApplet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App extends PApplet {

    public static final int WIDTH = 1500;
    public static final int HEIGHT = 1500;
    private  Space space;

    public App() {

    }

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        space = new Space(getGraphics());
//        for (int i = 10; i < 50; i++) {
//            //particles.add(new Particle(5,3+i,getGraphics()));
//            space.addParticle(1*i,500);
//        }
        var path = Paths.get("aocworld.txt");
        try {
            var reader = Files.newBufferedReader(path);
            String line;
            while((line = reader.readLine()) !=null) {
                var fields = line.split(" -> ");
                var f = fields[0].split(",");
                var row0 = Integer.parseInt(f[1]);
                var col0 = Integer.parseInt(f[0]);
                for (int i = 1; i < fields.length; i++) {
                    var f1 = fields[i].split(",");
                    var row1 = Integer.parseInt(f1[1]);
                    var col1 = Integer.parseInt(f1[0]);
                    space.addSegment(new Position(row0,col0), new Position(row1,col1));
                    row0 = row1;
                    col0 = col1;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        space.addSegment(new Position(10,20), new Position(20,20));
//        space.addSegment(new Position(20,20), new Position(20,30));
//        space.addSegment(new Position(20,30), new Position(10,30));
//        space.addSegment(new Position(80,0), new Position(0,0));
 //       space.addSegment(new Position(200,0), new Position(200,100));
        //frameRate(20);
    }

    @Override
    public void draw() {
        space.addParticle(0,500);
        space.update();
        background(55);
//        for (var p:particles) {
//            p.moveDown();
//        }
       space.draw();
    }

    public static void main(String[] args) {
        PApplet.main("fallingsand.App");
    }
}
