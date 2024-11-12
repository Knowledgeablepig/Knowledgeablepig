public class MapDemoManager {
    //So enemys and characters have to interact with each other too. The map manager will tell them if a square has certain properties
    //or are occupied. Hopefully this is a place that I can test if the paths an enemy takes will interact with squares that 
    //are water/mountain/or if they have bonuses like avoid or terrain bonuses. Or if they're a straight up wall lol

    public static char mapDemoEnvironment[][] = new char[][] {{'p','p','p','p','r','r','p','f','m','m','m','r','m','m','m','m','m'}
    ,{'c','p','p','p','f','r','p','p','p','f','p','f','m','m','m','m','m'}
    ,{'p','c','p','p','f','r','p','f','p','p','p','r','p','m','m','m','m'}
    ,{'p','p','p','p','r','r','p','p','f','p','p','r','p','m','m','m','m'}
    ,{'p','p','f','r','r','p','p','f','p','p','f','r','p','p','f','p','p'}
    ,{'p','f','p','r','r','p','p','p','p','p','p','r','p','p','p','p','p'}
    ,{'r','r','r','r','p','p','p','f','p','p','f','r','r','f','p','p','f'}
    ,{'r','p','r','r','r','p','p','r','p','r','p','f','r','r','r','p','p'}
    ,{'p','p','p','p','r','r','p','r','p','r','p','f','f','p','r','p','r'}
    ,{'p','p','p','p','r','r','p','f','p','r','r','r','p','f','p','p','r'}
    ,{'p','p','p','f','r','p','p','p','p','p','r','r','r','f','r','r','r'}
    ,{'p','f','p','p','r','p','p','p','r','r','r','f','r','r','r','f','p'}
    ,{'p','p','p','p','r','r','r','p','r','p','p','p','p','r','r','p','c'}
    ,{'p','p','p','f','p','r','r','p','p','f','p','p','f','p','r','f','c'}
    ,{'p','p','f','p','p','p','f','p','p','p','p','f','p','p','r','r','p'}
    ,{'r','r','r','r','r','r','r','r','r','r','r','r','r','r','r','r','r'}};


    public static char mapDemoOverlay[][] = new char[15][17];


    public MapDemoManager(){
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 17; j++){
                mapDemoOverlay[i][j] = '0';
            }
        }
    }


    public boolean mapCharacterChecker(double newX, double newY){
        int j = (int) (newX/25);
        int i = (int) (newY/25);
        
        if(mapDemoOverlay[i][j] ==  'o') return false;
        else if(mapDemoOverlay[i][j] == 'e') return false;


        return true;


    }

    public void mapCharacterSetter(double x, double y) {
        int j = (int) (x/25);
        int i = (int) (y/25);
        mapDemoOverlay[i][j] = 'o';
    }

    static public void mapEnemySetter(int x, int y) {
        //int j = (int) (x/25);
        //int i = (int) (y/25);
        mapDemoOverlay[y][x] = 'e';
    }


    public void print() {
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 17; j++){
                System.out.print(mapDemoOverlay[i][j]);
            }
            System.out.print('\n');
        }
    }


    public boolean CheckSquare(int j, int i){
        //System.out.println(mapDemoEnvironment[i][j]);
        if(mapDemoEnvironment[i][j] == 'f') return true;
        else if(mapDemoEnvironment[i][j] == 'p') return true;
        else if(mapDemoEnvironment[i][j] == 'c') return true;
        else if(mapDemoEnvironment[i][j] == 'r') return false;
        else {
            return false;
        }


    }

    



}