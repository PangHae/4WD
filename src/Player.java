import java.util.Arrays;

public class Player {
    private int hunger;
    private int thirst;
    private int action;
    private int fatigue;
    private Inventory inv;

    Player(int hunger, int thirst, int action,Inventory inv, int fatigue) {
        this.hunger = hunger;
        this.thirst = thirst;
        this.action = action;
        this.fatigue = fatigue;
        this.inv = inv;
    }

    public void _showStatus(){
        System.out.println("---status---");
        System.out.println("hunger: "+this.hunger);
        System.out.println("thirst: "+this.thirst);
        System.out.println("action: "+this.action);
        System.out.println("fatigue: "+this.fatigue);
        System.out.println("------------");
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }
    public void _showInventory(){

        System.out.println("---inventory---");
        int i = 0;
        for(i=0; i< 9; i++){
            System.out.println(Arrays.toString((this.inv.getResource())[i]));
        }
        System.out.println("---------------");
    }

    public void _gatheringUpdate(String name, int counts, int actionRequire){

        int i = 0;
        int currentCounts;
        for(i=0; i<9; i++){
            if(name.equals((this.inv.getResource())[i][0])){
                currentCounts = (int)(this.inv.getResource())[i][1];
                this.inv.setResource(currentCounts + counts, i);
                this.action = this.action - actionRequire;
            }
        }
    }

}
