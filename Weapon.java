public class Weapon extends Item {
    public int range;
    public int durability;
    public boolean magic;
    public int type;


    //ranks will go like 0 for bronze, 1 for iron, 2 for steel, 3 for silver, 4 for other weapons
    //I'm thinking that falchion will fall into the camp of 2 or 3. 

    public Weapon(int range, int durability, boolean magic, int type) {
        this.range = range;
        this.durability = durability;
        this.magic = magic;
        this.type = type;
    }




}