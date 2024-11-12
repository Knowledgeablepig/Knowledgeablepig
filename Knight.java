import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.animation.PathTransition;
import javafx.scene.shape.*;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.animation.SequentialTransition;
import java.lang.Math;

public class Knight extends Enemy {
/*public String knightPic = "ezgif.com-gif-maker-2.gif";
public Image knightImage = new Image(knightPic);
public ImageView enemyView = new ImageView(knightImage);*/
public BattleManager greg = new BattleManager();
public int route[][] = new int[100][2];
public int superCycle = 0;
public int Move;
public MapDemoManager mapDemoManager = new MapDemoManager();
public Rectangle healthBar = new Rectangle(20,3, Color.GREEN);



    public Knight(int health, int speed, int strength, int defense, int move, int hit, int weaponProf, int weapontype, MapDemoManager mdm, Pane pane){
        super(health, speed, strength, defense, move, weaponProf, hit, new Lance(weapontype), mdm, pane);
        Move = move;
    }

    public void healthBarSetUp(Pane pane){
        this.healthBar.setX(this.enemyView.getX());
        this.healthBar.setY(this.enemyView.getY()+22);
        pane.getChildren().add(this.healthBar);
    }


    public boolean isPath(int matrix[][], int n, int m) {
            // Defining visited array to keep
            // track of already visited indexes
            boolean visited[][] = new boolean[n][m];
    
            // Flag to indicate whether the
            // path exists or not
            boolean flag = false;
    
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // if matrix[i][j] is source
                    // and it is not visited
                    if (matrix[i][j] == 1 && !visited[i][j])
    
                        // Starting from i, j and
                        // then finding the path
                        if (isPath(matrix, i, j, visited)) {
                            // if path exists
                            flag = true;
                            break;
                        }
                }
            }
            if (flag) {
                return flag;
            } else {
                return false;
            }
                
        }
    
        // Method for checking boundaries
        public boolean isSafe(int i, int j, int matrix[][]) {
    
            if (i >= 0 && i < matrix.length && j >= 0
                && j < matrix[0].length)
                return true;
            return false;
        }
    
        // Returns true if there is a
        // path from a source (a
        // cell with value 1) to a
        // destination (a cell with
        // value 2)
        public boolean isPath(int matrix[][], int i, int j, boolean visited[][]){
    
            // Checking the boundaries, walls and
            // whether the cell is unvisited
            if(superCycle == 99) return false;
            if (isSafe(i, j, matrix) && matrix[i][j] != 0 && !visited[i][j]) {
                // Make the cell visited
                visited[i][j] = true;
    
                // if the cell is the required
                // destination then return true
                if (matrix[i][j] == 2)
                    return true;
    
                // traverse up
                boolean up = isPath(matrix, i - 1, j, visited);
    
                // if path is found in up
                // direction return true
                if (up) {
                    //System.out.println("up");
                    route[superCycle][0] = i-1;
                    route[superCycle][1] = j;
                    superCycle = superCycle + 1;
                    return true;
                }
    
                // traverse left
                boolean left
                    = isPath(matrix, i, j - 1, visited);
    
                // if path is found in left
                // direction return true
                if (left){
                    //System.out.println("left");
                    route[superCycle][0] = i;
                    route[superCycle][1] = j-1;
                    superCycle = superCycle + 1;
                    return true;
                }
                   
    
                // traverse down
                boolean down
                    = isPath(matrix, i + 1, j, visited);
    
                // if path is found in down
                // direction return true
                if (down) {
                    //System.out.println("down");
                    route[superCycle][0] = i+1;
                    route[superCycle][1] = j;
                    superCycle = superCycle + 1;
                    return true;
                }   
    
                // traverse right
                boolean right
                    = isPath(matrix, i, j + 1, visited);
    
                // if path is found in right
                // direction return true
                if (right) {
                    //System.out.println("right");
                    route[superCycle][0] = i;
                    route[superCycle][1] = j+1;
                    superCycle = superCycle + 1;
                    return true;
                }
            }
            // no path has been found
            return false;
        }



    //Time to recraft this fucking algorithim gosh dang it I have messed up and I hate everything. 
    public int[][] PathCreate(double enemx, double enemy,double playerx, double playery){
        int matrix[][] = new int[][] {{3,3,3,3,0,0,3,3,0,0,0,0,0,0,0,0,0}
        ,{0,3,3,3,3,0,3,3,3,3,3,3,0,0,0,0,0}
        ,{3,0,3,3,3,0,3,3,3,3,3,0,3,0,0,0,0}
        ,{3,3,3,3,0,0,3,3,3,3,3,0,3,0,0,0,0}
        ,{3,3,3,0,0,3,3,3,3,3,3,0,3,3,3,3,3}
        ,{3,3,3,0,0,3,3,3,3,3,3,0,3,3,3,3,3}
        ,{0,0,0,0,3,3,3,3,3,3,3,0,0,3,3,3,3}
        ,{0,3,0,0,0,3,3,0,3,0,3,3,0,0,0,3,3}
        ,{3,3,3,3,0,0,3,0,3,0,3,3,3,3,0,3,0}
        ,{3,3,3,3,0,0,3,3,3,0,0,0,3,3,3,3,0}
        ,{3,3,3,3,0,3,3,3,3,3,0,0,0,3,0,0,0}
        ,{3,3,3,3,0,3,3,3,0,0,0,3,0,0,0,3,3}
        ,{3,3,3,3,0,0,0,3,0,3,3,3,3,0,0,3,0}
        ,{3,3,3,3,3,0,0,3,3,3,3,3,3,3,0,3,0}
        ,{3,3,3,3,3,3,3,3,3,3,3,3,3,3,0,0,3}};

        
        int playx = (int) Math.round(playerx);
        int playy = (int) Math.round(playery);
        int enemyx = (int) Math.round(enemx);
        int enemyy = (int) Math.round(enemy);
        superCycle = 0;
        //route[0][0] = playx;
        //route[0][1] = playy;

    
        

        matrix[enemyy][enemyx] = 1;
        matrix[playy][playx] = 2;


         for(int i = 0; i < 100; i++) {
           route[i][0] = route[i][1] = 0;
        }

        boolean truth = this.isPath(matrix, 14,17);

        int gas[][] = new int[1][2];
        gas[0][0] = enemyx;
        gas[0][1] = enemyy;

        if(!truth) return gas;

        for(int m = 0; m < route.length; m++) {
            System.out.println("x "+ route[m][1] + " y "+ route[m][0]);
        }
        return route;
    }

 
    public void Move(Character Lucina){
        healthBar.setX(1000);
        if(!(this.alive)){
            return;
        }
        if(this.move == 0) {
            return;
        }
        double enemx = 0;
        double enemy = 0;
        if(this.enemyView.getX()%25 == 0) {
            System.out.println("hurh");
            enemx = (this.enemyView.getX())/25;
            enemy = (this.enemyView.getY())/25;
        } else {
            enemx = (this.enemyView.getX()-10)/25;
            enemy = (this.enemyView.getY()-10)/25;
        } 
        double charx = Lucina.poseView.getX()/25;
        double chary = Lucina.poseView.getY()/25;

        
        route = this.PathCreate(enemx, enemy, charx, chary);
        route = RouteShorten(route);
        System.out.println("enemy x " + enemx);
        int lengthLimiter = 0;
        for(int w = route.length-1; w >= 0; w--) {
            if(route[w][0] != 0 && route[w][1] != 0){
                if(route[w][0] == charx && route[w][1] == chary) break;
                lengthLimiter++;
            }
        }
        int length = Math.min(this.move,lengthLimiter);
        double routeActual[][] = new double[length][2];
        for(int k = 0; k < length; k++){
            System.out.println(routeActual[0][1]);
        }
        if(length == 1) return;
        int b = 0;
        for(int m = route.length-1; m >= 0; m--) {
            //System.out.println(m);
            if(route[m][0] != 0 && route[m][1] != 0){
                //System.out.println("WHe in this");
                routeActual[b][0] = route[m][1];
                routeActual[b][1] = route[m][0];
                b++;
            }
            if(b == length) break;
        }
        

        for(int i = 0; i < length; i ++) {
            System.out.println("routeActual(0) + " + i +" " + routeActual[i][0]);
            System.out.println("routeActual(1) + " + i +" " + routeActual[i][1]);
        }


         System.out.println("this.length 4 " + length);
        
            System.out.println("this.move 5 " + this.move);
            Line walklines[] = new Line[length];
            //Path pathes[] = new Path[length];
            PathTransition pathesTs[] = new PathTransition[length];
            //walklines[0] = new Line(this.enemyView.getX(), this.enemyView.getY(), routeActual[1][0]*25+15, routeActual[1][1]*25-15);
            //pahtes[0] = new Path();
            //pathesTs[0].setPath(walklines[0]);
            pathesTs[0] = new PathTransition();
            pathesTs[0].setPath(walklines[0]);
            pathesTs[0].setNode(this.enemyView);
            pathesTs[0].setDuration(Duration.millis(3000));
            SequentialTransition seqTran = new SequentialTransition();
            //seqTran.getChildren().add(pathesTs[0]);


            for(int k = 0; k < length-1; k++) {
                walklines[k] = new Line(routeActual[k][0]*25+10, routeActual[k][1]*25+10,routeActual[k+1][0]*25+10, routeActual[k+1][1]*25+10);
                //ahtes[k] = new Path();
                //pathes[k].setPath(walklines[k]);
                pathesTs[k] = new PathTransition();
                pathesTs[k].setPath(walklines[k]);
                pathesTs[k].setNode(this.enemyView);
                pathesTs[k].setDuration(Duration.millis(100));
                seqTran.getChildren().add(pathesTs[k]);
            }
            seqTran.play();

            this.enemyView.setX(routeActual[length-1][0]*25+ 10);
            this.enemyView.setY(routeActual[length-1][1]*25 + 10);

            healthBar.setX(this.enemyView.getX()); 
            healthBar.setY(this.enemyView.getY()+22);
    }
                /*double moveNumbers[] = new double[2];
                moveNumbers = this.MoveNumbersMethod(Lucina);
                if(moveNumbers[0] == 0 && moveNumbers[1] == 0) {
                } else {
                            Line walkLine1 = new Line(this.enemyView.getX(), this.enemyView.getY(),this.enemyView.getX() + moveNumbers[0],this.enemyView.getY());
                            Line walkLine2 = new Line(this.enemyView.getX() + moveNumbers[0], this.enemyView.getY(),this.enemyView.getX() + moveNumbers[0],this.enemyView.getY() + moveNumbers[1]);
                            //MoveTo moveto1 = new MoveTo();
                            //MoveTo moveto2 = new MoveTo();

                            //moveto1.setX(this.enemyView.getX() + moveNumbers[0]);
                            //moveto2.setY(this.enemyView.getY() + moveNumbers[1]);
                            double oldX =  this.enemyView.getX();
                            double oldY =  this.enemyView.getY();
                            double newX =  (this.enemyView.getX() + moveNumbers[0]);
                            double newY =  (this.enemyView.getY() + moveNumbers[1]);
                            






  
                        
                            
                            PathTransition pathTransition1 = new PathTransition();
                            
                            pathTransition1.setPath(walkLine1);
                            //pathTransition.setNode(this.enemyView);
                            PathTransition pathTransition2 = new PathTransition();
                            
                            pathTransition2.setPath(walkLine2);

                            SequentialTransition seqTran = new SequentialTransition();
                            seqTran.getChildren().add(pathTransition1);
                            seqTran.getChildren().add(pathTransition2);
                            seqTran.setNode(this.enemyView);
                            pathTransition1.setDuration(Duration.millis(500));
                            pathTransition2.setDuration(Duration.millis(250));
                            seqTran.play();
                            

                            
                            this.enemyView.setX(this.enemyView.getX() + moveNumbers[0]);
                            this.enemyView.setY(this.enemyView.getY() + moveNumbers[1]);
                }
                //System.out.println("There should be 5 of these");
                return;
    } */


    public void CheckAttack(Character Lucina) {
        System.out.println("This working?");
        if(!(this.alive)) return;
        double distX = Math.abs(Lucina.poseView.getX()-this.enemyView.getX());
        double distY = Math.abs(Lucina.poseView.getY()-this.enemyView.getY());
        if((distX + distY)/25 <= this.weapon.range) {
            greg.BattleRunEnemy(Lucina, this);
            return;
        }

        //For other characters they'll go here

        return;
    }


    public int[][] RouteShorten(int[][] brute) {
        int route[][] = new int[brute.length][2];
        for(int j = brute.length-1;j >= 0; j--) {
            System.out.println("xbrute =" + brute[j][1] + " ybrute " + brute[j][0]);
        }
        boolean shorten = false;
        int dist = 100;
        for(int m = 0; m < brute.length; m++){
            if(brute[m][0] != 0 && brute[m][1] != 0) {
            for(int k = m+2; k < brute.length; k++) {
                dist = Math.abs((brute[m][0] - brute[k][0]) + (brute[m][1] - brute[k][1]));
                if(dist == 1 || shorten) {
                    brute[m+1][0] = brute[k][0];
                    brute[m+1][1] = brute[k][1];
                }
                shorten = false;
            }
        }
        }

        for(int i = 0; i < brute.length;i++) {
            route[i][0] = brute[brute.length-1-i][0];
            route[i][1] = brute[brute.length-1-i][1];
            System.out.println("xshort =" + brute[i][1] + " yshort " + brute[i][0]);
        } 
        return brute;
    }
    
}