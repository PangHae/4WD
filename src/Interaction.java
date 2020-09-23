
public class Interaction{
    private String propName=null;
    private int probability= 0;
    private int actionRequire= 0;
    private int hungerRequire = 0;
    private int thirstRequire = 0;
    private int maximums = 0;
    private int minimums = 1;
    private Player p1;

    Interaction(Player p1) {
        this.p1 = p1;
    }

    public void _gathering(String propName,int probability, int actionRequire,int hungerRequire,int thirstRequire, int maximums,int minimums){
        this.propName= propName;
        this.actionRequire = actionRequire;
        this.hungerRequire = hungerRequire;
        this.thirstRequire = thirstRequire;
        this.maximums = maximums;
        this.probability = probability;
        this.minimums= minimums;
    
        int numbers = _gatheringCalculate();
        this.p1._gatheringUpdate(this.propName, numbers, this.actionRequire, this.hungerRequire, this.thirstRequire);
        _reset();
    }

    private int _gatheringCalculate(){
        int proba = (int)(Math.random()*100);
        int extraCount = (int)((Math.random()*10000)%10);
        if (extraCount >= this.maximums) extraCount = this.maximums-this.minimums;
        System.out.println(proba);
        if(this.probability >= proba) {
            return (extraCount+this.minimums);
        }else{
            return (this.minimums);
        }
    }
    private void _reset(){
        this.propName = null;
        this.probability = 0;
        this.actionRequire = 0;
        this.minimums = 0;
        this.maximums = 0;
    }
    //아이템 제작, 물품의 필요 재료 갯수 만큼 차감
    public void _making(String propName, int woodRequire, int stoneRequire, int actionRequire, int hungerRequire, int thirstRequire){
        this.p1._gatheringUpdate(propName, 1, actionRequire, hungerRequire, thirstRequire);
        this.p1._gatheringUpdate("wood", -1*(woodRequire), 0,0, 0);
        this.p1._gatheringUpdate("stone", -1*(stoneRequire), 0,0, 0);
    }

    public int _checkEquipment(String propName){
        int i;
        int j = 0;
        for(i=0; i<this.p1.getInv().getResource().length; i++){
            if((this.p1.getInv().getResource())[i][0].equals(propName)){
                j = i;
                break;
            }
        }

        if((int)(this.p1.getInv().getResource())[j][1] > 0){
            return 1;
        }
        else return 0;
    }

    

}
