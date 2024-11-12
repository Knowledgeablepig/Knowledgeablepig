import java.lang.Math;
import javafx.scene.shape.Line;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import java.util.Random;
public class BattleManager{
double rand = 0;
public static Image battleImage = new Image("BattleImage.png");
public static ImageView battleView = new ImageView(battleImage);
public static boolean animationSignal = true;


public void BattleManager(boolean LucinaMoveTurn) {
    }



    public void BattleRunEnemy(Character character, Enemy enemy) {
        double characterHit = character.hit + character.weaponProf;
        double characterAvoid = character.speed*0.5;

        double enemyHit = enemy.hit + enemy.weaponProf;
        double enemyAvoid = enemy.speed*.5;

        double characterAttack = character.strength;
        double characterDefend = character.defense;

        double enemyAttack =  enemy.strength;
        double enemyDefend =  enemy.defense;

        rand = 1-Math.random();

        System.out.println(characterAttack - enemyDefend);
        System.out.println(enemyAttack - characterDefend);

        if(characterHit - enemyAvoid >= rand) {
            if(characterAttack - enemyDefend > 0) enemy.health = enemy.health - (int)(characterAttack - enemyDefend);
            if(enemy.health <= 0) {
                enemy.enemyView.setX(20000);
                enemy.move = 0;
                enemy.Delete();
                System.out.print(enemy);
                return;
            }

        }

        rand = 1 - Math.random();

        if(enemyHit - characterAvoid >= rand) {
            if(enemyAttack - characterDefend > 0) { character.health = character.health - (int)(enemyAttack - characterDefend);
            EnemyAnimationRun(character, enemy);
            }
            if(character.health <= 0){ 
                character = null;
                System.out.print("YOU DIED");
                return;
            }

        }


        if(enemy.speed - character.speed > 4) {
            rand = 1 - Math.random();

            if(enemyHit - characterAvoid >= rand) {
                if(enemyAttack - characterDefend > 0) character.health = character.health - (int)(enemyAttack - characterDefend);
                EnemyAnimationRun(character, enemy);
            }
            if(character.health <= 0){
                character = null;
                System.out.print("YOU DIED");
                return;
            }
        } else if(character.speed - enemy.speed > 4) {
            rand = 1 - Math.random();

            if(characterHit - enemyAvoid >= rand) {
                if(characterAttack - enemyDefend > 0) enemy.health = enemy.health - (int)(characterAttack - enemyDefend);
            }
            if(enemy.health <= 0){
                enemy.enemyView.setX(20000);
                enemy.move = 0;
                enemy.Delete();
                System.out.print(enemy);
                return;
            }
        }

        System.out.println("your health " + character.health);
        System.out.println("their health " + enemy.health);
        return;

    }

    //I have technically a battle system working, so let's do this part first.
    public void BattleRunCharacter(){
        

    }

    public void EnemyAnimationRun(Character character, Enemy enemy) {
        double enemyX = enemy.enemyView.getX();
        double enemyY = enemy.enemyView.getY();
        double charX = character.poseView.getX();
        double charY = character.poseView.getY();
        double xdirection = enemyX - charX;
        double ydirection = enemyY - charY;

        System.out.println("animation x direction = " + xdirection);        
        System.out.println("animation y direction = " + ydirection);



        /*if(xdirection == 0){
            if(ydirection < 0) {
                Line line = new Line(enemyX, enemyY, enemyX, enemyY + 15);
                Line boomLine = new Line(enemyX, enemyY+14, enemyX, enemyY + 15);
                PathTransition path = new PathTransition();
                PathTransition boom = new PathTransition();
                //animationSignal = false;
                path.setDuration(Duration.millis(100));
                path.setPath(line);
                path.setNode(enemy.enemyView);
                boom.setNode(battleView);
                boom.setDuration(Duration.millis(20));
                path.play();
                boom.play();
                /*path.setOnFinished(e -> {
                    animationSignal = true;
                });
                return;
            } else {
                Line line = new Line(enemyX, enemyY, enemyX, enemyY - 15);
                Line boomLine = new Line(enemyX, enemyY-14, enemyX, enemyY - 15);
                PathTransition path = new PathTransition();
                PathTransition boom = new PathTransition();
                //animationSignal = false;
                path.setDuration(Duration.millis(100));
                path.setPath(line);
                path.setNode(enemy.enemyView);
                boom.setNode(battleView);
                boom.setDuration(Duration.millis(20));
                path.play();
                boom.play();
                /*path.setOnFinished(e -> {
                    animationSignal = true;
                });
                return;
            } 
        } else if(ydirection == 0) {
            if(xdirection < 0) {
                Line line = new Line(enemyX, enemyY, enemyX+15, enemyY);
                Line boomLine = new Line(enemyX+14, enemyY, enemyX+15, enemyY);
                PathTransition path = new PathTransition();
                PathTransition boom = new PathTransition();
                //animationSignal = false;
                path.setDuration(Duration.millis(100));
                path.setPath(line);
                path.setNode(enemy.enemyView);
                boom.setNode(battleView);
                boom.setDuration(Duration.millis(20));
                path.play();
                boom.play();
                /*path.setOnFinished(e -> {
                    animationSignal = true;
                });
                return;
            } else {
                Line line = new Line(enemyX, enemyY, enemyX-15, enemyY);
                Line boomLine = new Line(enemyX-14, enemyY, enemyX-15, enemyY);
                PathTransition path = new PathTransition();
                PathTransition boom = new PathTransition();
                //animationSignal = false;
                path.setDuration(Duration.millis(100));
                path.setPath(line);
                path.setNode(enemy.enemyView);
                boom.setNode(battleView);
                boom.setDuration(Duration.millis(20));
                boom.setPath(boomLine);
                path.play();
                boom.play();
                /*path.setOnFinished(e -> {
                    animationSignal = true;
                });
                return;
            }
        
        }*/
    }  






}