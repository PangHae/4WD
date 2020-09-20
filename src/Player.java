
public class Player {
    private int hunger;
    private int thirst;
    private int action;
    private Inventory inv;

    Player(int hunger, int thirst, int action,Inventory inv) {
        this.hunger = hunger;
        this.thirst = thirst;
        this.action = action;
        this.inv = inv;
    }

    public void _showStatus(){
        System.out.println("hunger: "+this.hunger);
        System.out.println("thirst: "+this.thirst);
        System.out.println("action: "+this.action);
    }
    //Getter & Setter

}
