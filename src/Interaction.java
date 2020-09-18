
public class Interaction{
    private String propName=null;
    private int probability= 0;
    private int actionRequire= 0;
    private int maximums = 0;
    private int minimums = 1;
    private Player p1;

    Interaction(Player p1) {
        this.p1 = p1;
    }

    public void _gathering(String propName,int probability, int actionRequire,int maximums,int minimums){
        this.propName= propName;
        this.actionRequire = actionRequire;
        this.maximums = maximums;
        this.probability = probability;
        this.minimums= minimums;

        int numbers = _gatheringCalculate();
        this.p1._gatheringUpdate(this.propName, numbers, this.actionRequire);
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
    public void _making(){
        
    }

}
