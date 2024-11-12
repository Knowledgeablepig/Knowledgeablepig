public class MapDemoManager {
    //So enemys and characters have to interact with each other too. The map manager will tell them if a square has certain properties
    //or are occupied. Hopefully this is a place that I can test if the paths an enemy takes will interact with squares that 
    //are water/mountain/or if they have bonuses like avoid or terrain bonuses. Or if they're a straight up wall lol

    public char mapDemoEnvironment[][] = new char[][] {{'p','p','p','p','r','r','p','f','m','m','m','r','m','m','m','m','m'}
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
    ,{'p','p','f','p','p','p','f','p','p','p','p','f','p','p','r','r','p'}};


    public char mapDemoOverlay[][] = new char[15][17];


    public MapManager(){
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 17; j++){
                mapDemoOverlay[i][j] = 'e';
            }
        }
    }


    public boolean mapCharacterChecker(Character character){
        return false;
    }



    



}