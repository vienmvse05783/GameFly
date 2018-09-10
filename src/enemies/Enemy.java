package enemies;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class Enemy extends GameObject {
    EnemyShoot enemyShoot;




    public Enemy(int x, int y){
        super(x,y);
       this.renderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
       this.boxCollider= new BoxCollider(x,y,50,50);

       enemyShoot =new EnemyShoot();
    }



    @Override
    public void run() {
        super.run();
        this.shoot();
        this.position.addUp(0,3);

    }

    private void shoot() {
    enemyShoot.run(this);

    }
    public void getHit(){
        this.destroy();
    }
}
