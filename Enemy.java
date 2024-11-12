import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
public class Enemy {

public int health, speed, strength, defense;
public int weaponProf, hit;
public int move;
public Weapon weapon;
public String knightPic = "ezgif.com-gif-maker-2.gif";
public Image enemyImage = new Image(knightPic);
public ImageView enemyView = new ImageView(enemyImage);
public MapDemoManager mdm;
public boolean alive = true;
public Pane pane;
//public ImageView enemyView;

    public Enemy(int health, int speed, int strength, int defense, int move, int weaponProf, int hit, Weapon weapon, MapDemoManager mdm, Pane pane) {
        this.health = health;
        this.speed = speed;
        this.strength = strength;
        this.defense = defense;
        this.move = move;
        this.hit = hit;
        this.weaponProf = weaponProf;
        this.weapon = weapon;
        this.mdm = mdm;
        this.pane = pane;
    }

    
    public void Delete(){
        this.health = 0;
        this.speed = 0;
        this.strength = 0;
        this.defense = 0;
        this.move = 0;
        this.hit = hit;
        this.weaponProf = 0;
        this.alive = false;
        this.enemyView.setX(1000);
        return;
    }



}