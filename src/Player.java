import java.util.Arrays;
import java.util.Random;

public class Player {
    private int hunger;
    private int thirst;
    private int action;
    private int fatigue;
    private int escape = 0; //escape 상태 체크 용 변수, 1이면 탈출 성공 0이면 진행, -1 이면 게임 종료
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

    public int getEscape(){
        return this.escape;
    }

    public void setEscape(int escape){
        this.escape = escape;
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
        for(i=0; i< this.inv.getResource().length; i++){
            System.out.println(Arrays.toString((this.inv.getResource())[i]));
        }
        System.out.println("---------------");
    }

    public void _gatheringUpdate(String name, int counts, int actionRequire, int hungerRequire, int thirstRequire){

        int i = 0;
        int currentCounts;
        
        for(i=0; i<this.inv.getResource().length; i++){
            if(name.equals((this.inv.getResource())[i][0])){
                currentCounts = (int)(this.inv.getResource())[i][1];
                this.inv.setResource(currentCounts + counts, i);
                this.action = this.action - actionRequire;
                if(this.hunger < hungerRequire){
                    this.hunger = 0;
                }else{
                    this.hunger = this.hunger - hungerRequire;
                }

                if(this.thirst < thirstRequire){
                    this.thirst = 0;
                }else{
                    this.thirst = this.thirst - thirstRequire;
                }

            }
        }
    }

    //meet, fruits, water 사용
    public void _eating(String propName){
        if(propName.equals("meet")){
            _gatheringUpdate("meet", -1, 0, 0, 0);
            this.hunger+=5;
            if(this.hunger > 10)
                this.hunger = 10;
        }
        else if(propName.equals("fruits")){
            _gatheringUpdate("fruits", -1, 0, 0, 0);
            this.hunger+=3;
            if(this.hunger > 10)
                this.hunger = 10;
        }
        else if(propName.equals("water")){
            _gatheringUpdate("water", -1, 0, 0, 0);
            this.thirst += 4;
            if(this.thirst > 10)
                this.thirst = 10;
        }
        else return ;
    }

    //피로도 업데이트
    // state = -1 : 피로도 감소
    // state = 1 : 피로도 회복
    public void _updateFatigue(int state, int checkFatigue){

        if(state == 1){
            this.fatigue += checkFatigue;
            if(this.fatigue > 10){
                this.fatigue = 10;
            }
        }
        else if(state == -1){
            this.fatigue -= checkFatigue;
            if(this.fatigue < 0){
                this.fatigue = 0;
            }
        }
    }


    //return 1 : 탈출 성공
    //return 0 : 탈출 실패
    public int _escape(int state){
        
        int randomNumber;
        Random rm = new Random();
        randomNumber = rm.nextInt(100);
        //연기로 배에 구조요청
        if(state == 0){
            System.out.println("smoke to rescue");
            if(randomNumber >= 95){
                return 1;
            }
            else return 0;
        }

        //돌로 SOS 그려서 비행기에 구조 요청
        else if(state == 1){
            System.out.println("draw SOS to rescue");
            if(randomNumber >= 95){
                return 1;
            }
            else return 0;
        }
        //제작된 배로 직접 탈출
        else if(state == 2){
            System.out.println("try escape with your ship");
            //ship2
            //탈출 확률 75%
            if((int)(this.inv.getResource())[11][1] >= 1){
                if(randomNumber >= 25 ){
                    return 1;
                }
                else return -1;
            }
            //ship1
            //탈출 확률 50%
            else if((int)(this.inv.getResource())[10][1] >= 1){
                if(randomNumber >= 50 ){

                    return 1;
                }
                else return -1;
            }
            //ship0
            //탈출 확률 25%
            else if((int)(this.inv.getResource())[9][1] >= 1){
                if(randomNumber >= 75 ){

                    return 1;
                }
                else return -1;
            }
            else return 0;
        }
        else return 0;
    }

}
