package bases;


import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;
    public  boolean isActive;
    public  boolean isAlive;
    private static ArrayList<GameObject> gameObjects=new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects=new ArrayList<>();

    public static void add(GameObject g){
       newGameObjects.add(g);
    }
    public  static void runAll(){
        for(GameObject go: gameObjects){
            if(go.isActive && ! go.isAlive)
            go.run();
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        System.out.println(gameObjects.size());
    }

    public  static void renderAll(Graphics g){
        for(GameObject go: gameObjects){
            if(go.isActive && !go.isAlive)
            go.render(g);
        }
    }
    public static<T extends GameObject> T  recycle(Class<T>cls){
        for(GameObject go: gameObjects){
            if(! go.isActive ){
                if(go.getClass().equals(cls)){
                   return  (T) go;
                }
            }
        }
        return null;
    }
    //Generics


    public static <T extends GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls){
        for (GameObject go: gameObjects){
            if (go.boxCollider !=null && go.isActive){
                if(go.getClass().equals(cls) ){
                    if(go.boxCollider.collideWith(boxCollider)){
                        return (T)go;
                    }
                }
            }
        }
        return  null;
    }


    public BoxCollider boxCollider;
    public GameObject(int x,int y){
        this.position =new Vector2D(x,y);
        this.renderer=null; //not yet specified
        this.boxCollider = null;
        this.isActive=true;
    }
    public void run(){
        if(this.boxCollider !=null){
            this.boxCollider.position.x=this.position.x;
            this.boxCollider.position.y=this.position.y;
            this.boxCollider.run();

        }

    }
    public void render(Graphics g){
        if(this.renderer!=null){
            this.renderer.render(g,this.position);
        }
        if(this.boxCollider !=null){
            this.boxCollider.render(g);
        }
    }
    public void destroy(){

        this.isActive = false;
    }
    public void gameOver() {
        this.isAlive = true;
        System.out.println("game over");
    }
}
