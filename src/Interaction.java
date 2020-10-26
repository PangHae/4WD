
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
        if(propName.equals("ship1")) this.p1._gatheringUpdate("ship0", -1 , 0, 0, 0);
        else if(propName.equals("ship2")) this.p1._gatheringUpdate("ship1", -1 , 0, 0, 0);
        else if(propName.equals("house1")) this.p1._gatheringUpdate("house0", -1 , 0, 0, 0);
        else if(propName.equals("house2")) this.p1._gatheringUpdate("house1", -1 , 0, 0, 0);
        else if(propName.equals("house3")) this.p1._gatheringUpdate("house2", -1 , 0, 0, 0);
        else return;
    }

    //아이템 확인해서 드랍률 증가
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

    // 집 확인해서 행동력 증가
    public int _checkHouse(){
        if((int)(this.p1.getInv().getResource())[14][1] > 0 ){
            return 5;
        }
        else if((int)(this.p1.getInv().getResource())[13][1] > 0 ){
            return 3;
        }
        else if((int)(this.p1.getInv().getResource())[12][1] > 0 ){
            return 1;
        }
        else return 0;
        
    }

    //피로도 확인해서 최대활동력 차감
    //hunger = 0 이면 매일 1, thirst = 0이면 매일 2 fatigue 감소
    //fatigue 5 이하면 활동력 5 감소
    //fatigue 0 이면 사망
    //hunger, thrist 확인해서 fatigue 감소
    public int _checkStatus(){
        if(this.p1.getHunger() == 0 && this.p1.getThirst() == 0){
            return 3;
        }
        else if(this.p1.getThirst() == 0){
            return 2;
        }
        else if(this.p1.getHunger() == 0){
            return 1;
        }
        else return 0;

    }
}
