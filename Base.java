//Gonna try and do this again, but with some actual thought put into it first. So step 1 is to make a window and have it display
//all the correct things, and time to import some packages.
import javafx.application.Application;
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
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import java.lang.Math;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.animation.SequentialTransition;

public class Base extends Application {
public Image battleImage = new Image("BattleImage.png");
public ImageView battleView = new ImageView(battleImage);
public Pane pane;
public Scene scene;
public MapDemoManager mapDemoManager = new MapDemoManager();

    //Set up for the background
    public void start(Stage primaryStage) {
    pane = new Pane();
    Image background = new Image("Background1.png");
    ImageView backgroundView = new ImageView(background);
    backgroundView.setX(0);
    backgroundView.setY(0);
    Line mouseHighTop = new Line();
    Line mouseHighLeft = new Line();
    Line mouseHighRight = new Line();
    Line mouseHighBottom = new Line();
    

    mouseHighTop.setStroke(Color.YELLOW);
    mouseHighLeft.setStroke(Color.YELLOW);
    mouseHighRight.setStroke(Color.YELLOW);
    mouseHighBottom.setStroke(Color.YELLOW);

    //Line checkerBoardX[] = new Line[18];
    //Line checkerBoardY[] = new Line[20];

    pane.getChildren().add(backgroundView);
    pane.getChildren().add(mouseHighTop);
    pane.getChildren().add(mouseHighLeft);
    pane.getChildren().add(mouseHighRight);
    pane.getChildren().add(mouseHighBottom);


    //Adding background to the pane
    //pane.getChildren().add(backgroundView);
    //pane.getChildren().add(mouseHigh);

    pane.getChildren().add(BattleManager.battleView);
    BattleManager.battleView.setX(200000);
    BattleManager.battleView.setY(200000);
    

    //Creating the scene (Any scene stuff goes here)
    scene = new Scene(pane,428,378);

    primaryStage.setResizable(false);
    primaryStage.setTitle("Awakening Spin off");
    primaryStage.setScene(scene);
    primaryStage.show();



    

    //Character creations
    Character Lucina = new Character("ezgif.com-gif-maker-3.gif", 40, 20, 20, 15, 80, 20, new Falchion(), mapDemoManager);
    Lucina.poseView.setX(200);
    Lucina.poseView.setY(200);
    mapDemoManager.mapCharacterSetter(200,200);

    pane.getChildren().add(Lucina.poseView);
    pane.getChildren().add(Lucina.itemView);
    pane.getChildren().add(Lucina.waitView);

    
    //Media backgroundSong = new Media("chasdayrain.wav");
    //MediaPlayer songPlayer = new MediaPlayer(backgroundSong);


    //Enemy Creations:
    Knight knightOne = new Knight(40, 12, 20, 10, 4, 50, 10, 1, mapDemoManager, pane);
    knightOne.enemyView.setX(225);
    knightOne.enemyView.setY(300);
    knightOne.healthBarSetUp(pane);
    mapDemoManager.mapEnemySetter(9, 1);
    
    // Knight knightTwo = new Knight(40, 12, 20, 10, 3, 50, 10, 1, mapDemoManager);
    // knightTwo.enemyView.setX(150);
    // knightTwo.enemyView.setY(25);
    // mapDemoManager.mapEnemySetter(6, 1);

    // Knight knightThree = new Knight(40, 12, 20, 10, 3, 50, 10, 1, mapDemoManager);
    // knightThree.enemyView.setX(150);
    // knightThree.enemyView.setY(325);
    // mapDemoManager.mapEnemySetter(6, 13);

    // Knight knightFour = new Knight(40, 12, 20, 10, 4, 50, 10, 1, mapDemoManager);
    // knightFour.enemyView.setX(300);
    // knightFour.enemyView.setY(325);
    // mapDemoManager.mapEnemySetter(12,13);

    // Knight knightFive = new Knight(40, 12, 20, 10, 4, 50, 10, 1, mapDemoManager);
    // knightFive.enemyView.setX(25);
    // knightFive.enemyView.setY(325);
    // mapDemoManager.mapEnemySetter(1, 13);

    pane.getChildren().add(knightOne.enemyView);
    // pane.getChildren().add(knightTwo.enemyView);
    // pane.getChildren().add(knightThree.enemyView);
    // pane.getChildren().add(knightFour.enemyView);
    // pane.getChildren().add(knightFive.enemyView);



    //Takes in a scene and actually displays it
    primaryStage.setResizable(false);
    primaryStage.setTitle("Awakening Spin off");
    primaryStage.setScene(scene);
    primaryStage.show();


    //mapDemoManager.print();


    scene.setOnMouseMoved(e -> {
        mouseHighLight(e.getX(), e.getY(), mouseHighTop, mouseHighBottom, mouseHighLeft, mouseHighRight);
    });





    backgroundView.setOnMouseClicked(e -> {
            Lucina.Move(Lucina.poseView.getX(), Lucina.poseView.getY(), e.getX(), e.getY());
            
    });

    //Activiates the clicked feature, character can do actions from here.
    Lucina.poseView.setOnMouseClicked(e -> {
        if(!(Lucina.clicked)) { 
            Lucina.clicked = true;
            Lucina.PopUpMenu();

        } else if(Lucina.clicked) {
            Lucina.clicked = false;
            Lucina.PopDownMenu();

        }
    });

    Lucina.waitView.setOnMouseClicked(e -> {
        Lucina.moveTurn = false;
        Lucina.PopDownMenu();
    });






    

        System.out.println(Lucina.moveTurn);
        //



    scene.setOnKeyPressed(e-> {
        if(e.getCode() == KeyCode.TAB) {
                Lucina.PopDownMenu();
                knightOne.Move(Lucina);
                knightOne.CheckAttack(Lucina);
                System.out.println(Lucina.poseView.getX());
                System.out.println(Lucina.poseView.getY());

                //System.out.println(knightOne.enemyView.getX());
                //System.out.println(knightOne.enemyView.getY());

                
                //knightTwo.Move(Lucina);
                //knightTwo.CheckAttack(Lucina);

                 
                //knightThree.Move(Lucina);
                //knightThree.CheckAttack(Lucina);
                

                /*knightFour.Move(Lucina);
                knightFour.CheckAttack(Lucina); 

                knightFive.Move(Lucina);*/
                //knightFive.CheckAttack(Lucina);
                
                //System.out.println(knightFive.enemyView.getX());
                //System.out.println(knightFive.enemyView.getY());
                Lucina.moveTurn = true;
            
        }
            

    });


}








    


    public static void main(String[] args){
    Application.launch(args);
    

    }


    

    
    public void mouseHighLight(double x, double y, Line mouseHighTop, Line mouseHighBottom, Line mouseHighLeft, Line mouseHighRight) {
        int i = 0;
        int j = 0;
        while(i * 25 < x) {
            i++;
        } while(j * 25 < y) {
            j++;
        }
        mouseHighTop.setStartX((i-1)*25);
        mouseHighTop.setStartY((j-1)*25);
        mouseHighTop.setEndX(i*25);
        mouseHighTop.setEndY((j-1)*25);

        mouseHighLeft.setStartX((i-1)*25);
        mouseHighLeft.setStartY((j-1)*25);
        mouseHighLeft.setEndX((i-1)*25);
        mouseHighLeft.setEndY(j*25);

        mouseHighRight.setStartX(i*25);
        mouseHighRight.setStartY((j-1)*25);
        mouseHighRight.setEndX(i*25);
        mouseHighRight.setEndY(j*25);

        mouseHighBottom.setStartX((i-1)*25);
        mouseHighBottom.setStartY(j*25);
        mouseHighBottom.setEndX(i*25);
        mouseHighBottom.setEndY(j*25);
    }
    
    



}