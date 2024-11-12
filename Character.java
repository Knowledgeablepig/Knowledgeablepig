
import javafx.scene.layout.Pane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Shape;

public class Character{

private String poseFileName = "ezgif.com-gif-maker-3.gif";
public Image poseImage = new Image(poseFileName);
public ImageView poseView = new ImageView(poseImage);
public int health, speed, strength, defense;
public int hit;
public int weaponProf;
public boolean clicked = false;
public boolean MoveClick = false;
public boolean moveTurn = true;
public Weapon equippedWeapon;
private int move = 5;
public Item[] itemList = new Item[5];
public MapDemoManager mdm;


//Item menus and stuff:
Image itemImage = new Image("Item.png");
Image waitImage = new Image("Wait.png");
ImageView itemView = new ImageView(itemImage);
ImageView waitView = new ImageView(waitImage);



public Character(String fileName, int health, int speed, int strength, int defense, int hit, int weaponProf, Weapon weapon, MapDemoManager mdm) {
    this.poseFileName = fileName;
    this.health = health;
    this.speed = speed;
    this.strength = strength;
    this.defense = defense;
    this.hit = hit;
    this.weaponProf = weaponProf;
    this.equippedWeapon = weapon;
    this.itemList[0] = weapon;
    this.waitView.setX(20000);
    this.itemView.setX(20000);
    this.mdm = mdm; 
    }


/*public static ImageView getImageView() {
    return Character.poseView;
}*/

/*public static void ChangeImageViewValue(int x, int y) {
    this.poseView.setX(x);
    this.poseView.setY(y);
    return;
}*/

        /*this.poseView.setOnMouseClicked(e -> {
            System.out.println('worked!');

        });*/
    public boolean MoveCheck(double currx, double curry, double newx, double newy) {
        double xDist = newx - currx;
        if(xDist < 0) xDist = xDist*(-1);
        double yDist = newy - curry;
        if(yDist < 0) yDist = yDist*(-1);
        //System.out.println("yDist" + yDist);
        //System.out.println("xDist" + xDist);
        if((yDist + xDist)/25 <= move) {
            return true;
        } else {
            return false;
        }


    }

    public void PopUpMenu() {
        this.itemView.setX(this.poseView.getX() + 20);
        this.itemView.setY(this.poseView.getY());
        this.waitView.setX(this.poseView.getX() + 20);
        this.waitView.setY(this.poseView.getY() - 20);
    }

    public void PopDownMenu() {
        this.itemView.setX(20000);
        //this.itemView.setY(20000);
        this.waitView.setX(20000);
        //this.waitView.setY(20000);
        

    }



    public void Move(double currx, double curry, double newx, double newy){
        if(this.clicked & this.moveTurn) {
            if(this.MoveCheck(currx, curry, newx, newy)) {
                    this.PopDownMenu();
                    int i = 0;
                    int j =0;
                    while(i*25 < newx) {
                        i++;
                    }
                    while(j*25 < newy) {
                        j++;
                    }
                    

                    double roundedX = (i-1)*25;//Math.round(newx/25);
                    double roundedY = (j-1)*25;//Math.round(newy/25);
                    //roundedX = roundedX*25;
                    //roundedY = roundedY*25;
                    System.out.println(this.poseView.getX() + " " + roundedX);
                    Line walkLine = new Line(currx, curry, roundedX + 10, roundedY + 10);
                    PathTransition path = new PathTransition();
                    path.setDuration(Duration.millis(100));
                    path.setPath(walkLine);
                    path.setNode(this.poseView);
                    path.play();
                    this.poseView.setY(roundedY + 10);
                    this.poseView.setX(roundedX + 10);
                    this.clicked = false;
                    this.MoveClick = false;
                    this.moveTurn = false;
                    System.out.println("x " + this.poseView.getX());
                    System.out.println("y " + this.poseView.getY());

            }






        }
    }



    

}