package Enemies;

import Bases.FrameCounter;
import Bases.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class EnemySpawn {
    Random random;
    public ArrayList<Enemy> enemies;
    FrameCounter frameCounter = new FrameCounter(200);
    public EnemySpawn(){
        enemies = new ArrayList<>();
        random = new Random();
    }

    public void run(){
        frameCounter.run();
        if (frameCounter.expired){
            int posX = random.nextInt(600);
            Enemy enemy = new Enemy(posX, 0);
            GameObject.add(enemy);
            frameCounter.reset();
        }
    }
}
