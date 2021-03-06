
public class Systems {
    private int days=1;
    private int maximumDays;
    private int times;
    private Commands cmd;
    private Player p1;
    private String[] blockCmd;
    private int interpretedCommand;
    private int action;
    private Interaction interaction;
    private LoadData sl = new LoadData();
    private TxtRead trd = new TxtRead();
    private String[][] loadData = new String[21][2];
    
    
    Systems(int maximumDays,int times){
        this.maximumDays = maximumDays;
        this.times= times;
    }

    public void _dayGame(){
        
        _setPlayers();
        interaction =  new Interaction(this.p1);
       while(true){
            if(_isNotFinished()){
                this.blockCmd = this.cmd._inputCommand();
                interpretedCommand = _interpretCommand();
                _excuteCommand(interpretedCommand);
                action = _checkAction();
                //p1._showInventory();
                p1._showStatus();
                if(action == 1){
                    _nextDay();
                    System.out.println(this.days + "day");                    
                }
            }
            //탈출 성공
            else if(this.p1.getEscape() == 1){
                _escapeSuccess();
                break;
            }
            //탈출 실패 및 게임 오버
            else{
                _newGame();
                break;
            }
        }
        
    }

    private void _newGame(){
        System.out.println("-GameOver-");
    }

    private void _escapeSuccess(){
        System.out.println("-Escape Success!!-");
    }
    private void _setPlayers(){
        this.cmd = new Commands();
        Inventory inv = new Inventory(0,0,0,0,0,0,0,0,0,0,0,1,0,0,0);
        this.p1 = new Player(10,10,10,inv,10);
        
    }

    private boolean _isNotFinished(){
        if(this.days>=this.maximumDays || (this.p1.getFatigue() == 0) || (this.p1.getEscape() != 0)) return false;
        else return true;
    }

    private void _nextDay(){
        this.days+=1;
        this.p1._updateFatigue(-1,this.interaction._checkStatus());
    }

    //command 해석해서 리턴
    private int _interpretCommand(){

        if(this.blockCmd==null){
            return -1;
        }
        if(this.blockCmd[0].equals("gathering") && this.blockCmd.length==2){
            if(this.blockCmd[1].equals("wood")) return 0;
            else if(this.blockCmd[1].equals("stone")) return 1;
            else if(this.blockCmd[1].equals("meat")) return 2;
            else if(this.blockCmd[1].equals("fruits")) return 3;
            else if(this.blockCmd[1].equals("water")) return 4;
            else return -2;
        }
        else if(this.blockCmd[0].equals("make") && this.blockCmd.length==2){
            
            if(_checkMaterials(this.blockCmd[1]) == 1){
                if(this.blockCmd[1].equals("stonesword")) return 10;
                else if(this.blockCmd[1].equals("stoneaxe")) return 11;
                else if(this.blockCmd[1].equals("stonepickaxe")) return 12;
                else if(this.blockCmd[1].equals("ship0")) return 20;
                else if(this.blockCmd[1].equals("ship1")) return 21;
                else if(this.blockCmd[1].equals("ship2")) return 22;
                else if(this.blockCmd[1].equals("house1")) return 30;
                else if(this.blockCmd[1].equals("house2")) return 31;
                else if(this.blockCmd[1].equals("house3")) return 32;
                else return -2;
            }
            else if(_checkMaterials(this.blockCmd[1]) == -1){
                System.out.println("만들 수 없는 아이템입니다.");
                return -10;
            }

            else return -3;
            
        }

        else if(this.blockCmd[0].equals("use") && this.blockCmd.length==2){
            if(_checkMaterials(this.blockCmd[1]) == 1){
                if(this.blockCmd[1].equals("meat")) return 40;
                else if(this.blockCmd[1].equals("fruits")) return 41;
                else if(this.blockCmd[1].equals("water")) return 42;
                else return -2;
            }
            else if(_checkMaterials(this.blockCmd[1]) == -1) return -10;
            else return -3;

        }
        else if(this.blockCmd[0].equals("rescue") && this.blockCmd.length==2){
            if(_checkMaterials(this.blockCmd[1]) == 1){
                if(this.blockCmd[1].equals("smoke")) return 80;
                else if(this.blockCmd[1].equals("sos")) return 81;
                else return -2;
            }
            else if(_checkMaterials(this.blockCmd[1]) == -1) return -10;

            else return -3;
        }

        else if(this.blockCmd[0].equals("escape")){
            int currentShip = (int)(this.p1.getInv().getResource())[8][1] + (int)(this.p1.getInv().getResource())[9][1] + (int)(this.p1.getInv().getResource())[10][1];
            if(currentShip > 0) return 90;
            else return -3;
        }
        else if(this.blockCmd[0].equals("sleep")){
            return 100;
        }
    
        else if(this.blockCmd[0].equals("cheat")){
            return 200;
        }

        else if(this.blockCmd[0].equals("save")){
            return 300;
        }
        else if(this.blockCmd[0].equals("load")){
            return 301;
        }
        else if(this.blockCmd[0].equals("savelist")){
            return 302;
        }
        else if(this.blockCmd[0].equals("help")){
            //인자값 오류
            if(this.blockCmd[1].equals("error")){
                return -1;
            }
            //인자값 없을 때
            else if(this.blockCmd[1].equals("null")){
                return 400;
            }
            //인자값 있을 때
            else return 401;
        }
        else if(this.blockCmd[0].equals("showinven")){
            return 500;
        }
        else{
            return -1;
        }

    }

    //해석된 커맨드의 리턴 값으로 실제 커맨드 실행
    private void _excuteCommand(int command){
        int currentAction = this.p1.getAction();
        String notEnoughAction = "not enough Action";
        if(command == 0){
            if(currentAction >= 1){
                if(this.interaction._checkEquipment("stoneaxe") == 1){
                    System.out.println("gathering wood wiht stoneaxe!!");
                    interaction._gathering("wood", 100, 1, 1,2,13,8);
                }
                else{
                    System.out.println("gathering wood!!");
                    interaction._gathering("wood", 70, 1, 1,2,7, 2);
                }
                
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 1){
            if(currentAction >= 1){

                if(this.interaction._checkEquipment("stonepickaxe") == 1){
                    System.out.println("gathering stone with stonepickaxe");
                    interaction._gathering("stone", 100, 1, 1, 2, 13, 8);

                }
                else{
                    System.out.println("gathering stone!!");
                    interaction._gathering("stone", 70, 1, 1, 2, 7, 2);
                }
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 2){
            if(currentAction >= 3){

                if(this.interaction._checkEquipment("stonesword") == 1){
                    System.out.println("gathering meat with stonesword!!");
                    interaction._gathering("meat", 100, 3, 3, 2, 10, 7);

                }
                else{
                    System.out.println("gathering meat!!");
                    interaction._gathering("meat", 70, 3, 3, 2, 5, 3);
                }
            }
            else{
                System.out.println(notEnoughAction);
            }

        }
        else if(command == 3){
            if(currentAction >= 1){
                System.out.println("gathering fruits");
                interaction._gathering("fruits", 100, 1, 1, 2, 3, 1);
            }
            else{
                System.out.println(notEnoughAction);
            }
        }

        else if(command == 4){
            if(currentAction >= 1){
                System.out.println("gathering water");
                interaction._gathering("water", 100, 1, 1, 1, 5, 2);
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 10){
            if(currentAction >= 5){
                System.out.println("make stonesword!!");
                interaction._making("stonesword",30,30, 5,5,5);
            }
            else{
                System.out.println(notEnoughAction);
            }
            
        }
        else if(command == 11){
            if(currentAction >= 5){
                System.out.println("make stoneaxe!!");
                interaction._making("stoneaxe",15,15, 5,5,5);
            }
            else{
                System.out.println(notEnoughAction);
            }

        }
        else if(command == 12){
            if(currentAction >= 5){
                System.out.println("make stonepickaxe!!");
                interaction._making("stonepickaxe",25,25,5,5,5);
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 20){
            if(currentAction >= 10){
                System.out.println("make ship0!!");
                interaction._making("ship0", 100,100, 10 , 8, 8);
            }
            else{
                System.out.println(notEnoughAction);
            }

        }else if(command == 21){
            if(currentAction >= 12){
                System.out.println("make ship1!!");
                interaction._making("ship1", 150,150,12 , 8, 8);
            }
            else{
                System.out.println(notEnoughAction);
            }

        }else if(command == 22){
            if(currentAction >= 15){
                System.out.println("make ship2!!");
                interaction._making("ship2",200,200, 15 , 8, 8);
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 30){
            if(currentAction >= 10){
                System.out.println("make house1!!");
                interaction._making("house1", 50,50,10 , 8, 8);
            }
            else{
                System.out.println(notEnoughAction);
            }

        }else if(command == 31){
            if(currentAction >= 11){
                System.out.println("make house2!!");
                interaction._making("house2", 75,75,11 , 8, 8);
            }
            else{
                System.out.println(notEnoughAction);
            }

        }else if(command == 32){
            if(currentAction >= 12){
                System.out.println("make house3!!");
                interaction._making("house3",100,100, 12 , 8, 8);
            }
            else{
                System.out.println(notEnoughAction);
            }

        }else if(command == 40){
            System.out.println("eat meat!!");
            p1._eating("meat");
        }else if(command == 41){
            System.out.println("eat fruits!!");
            p1._eating("fruits");
        }else if(command == 42){
            System.out.println("drink water!!");
            p1._eating("water");
        }

        else if(command == 80){
            if(currentAction >= 5){
                p1._gatheringUpdate("wood", -30, 5, 5, 5);
                p1.setEscape(p1._escape(0));
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 81){
            if(currentAction >= 5){
                p1._gatheringUpdate("stone", -30, 5, 5, 5);
                p1.setEscape(p1._escape(1));
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 90){
            if(currentAction >= 10){
                p1.setEscape(p1._escape(2));
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 100){
            System.out.println("sleep!");
            this.p1._updateFatigue(1, this.p1.getAction());
            this.p1.setAction(0);

        }
        else if(command == 200){
            System.out.println("use cheat!!");
            this.p1._gatheringUpdate("wood", 1000, 0, 0, 0);
            this.p1._gatheringUpdate("stone", 1000, 0, 0, 0);
            this.p1._gatheringUpdate("water", 1000, 0, 0, 0);
            this.p1._gatheringUpdate("meat", 1000, 0, 0, 0);
            this.p1._gatheringUpdate("stonesword", 1, 0, 0, 0);
            this.p1._gatheringUpdate("stoneaxe", 1, 0, 0, 0);
            this.p1._gatheringUpdate("stonepickaxe", 1, 0, 0, 0);
            this.p1._gatheringUpdate("house3", 1, 0, 0, 0);
            this.p1._gatheringUpdate("house0", -1, 0, 0, 0);

        }
        else if(command == 300){
            
            sl._setdata(_makeSaveData());
            sl._setlocation(this.blockCmd[1]);
            sl._save();

        }
        else if(command == 301){
            sl._setlocation(this.blockCmd[1]);
            loadData = sl._load();
            if(loadData != null)  _useLoadData(loadData);
        }
        else if(command == 302){
            sl._showlist();
        }

        else if(command == 400){
            trd._readTxt("help");
        }
        else if(command == 401){
            _help(this.blockCmd[1]);
        }
        else if(command == 500){
            p1._showInventory();
        }
        else if(command == -3){
            System.out.println("not enough materials");
        }
        else{
            System.out.println("error!!");
        }
    }

    //남은 행동력 계산
    //집 업글 정도에 따라 행동력 추가
    //피로도 수치에 따라 행동력 감소
    private int _checkAction(){

        int currentAction = this.p1.getAction();
        int addAction = interaction._checkHouse();
        int currentFatigue = this.p1.getFatigue();
        if(currentAction == 0){
            if(currentFatigue <= 5){
                this.p1.setAction(5+ addAction);
            }
            else{
                this.p1.setAction(10 + addAction);
            }
            return 1;
        }
        else{
            return 0;
        }

    }

    
    //제작시 아이템 갯수 체크
    private int _checkMaterials(String makingItem){

        int wood = (int)(p1.getInv().getResource())[1][1];
        int stone = (int)(p1.getInv().getResource())[2][1];
        int meat = (int)(p1.getInv().getResource())[6][1];
        int fruits = (int)(p1.getInv().getResource())[7][1];
        int water = (int)(p1.getInv().getResource())[0][1];
        int ship0 = (int)(p1.getInv().getResource())[8][1];
        int ship1 = (int)(p1.getInv().getResource())[9][1];
        int house0 = (int)(p1.getInv().getResource())[11][1];
        int house1 = (int)(p1.getInv().getResource())[12][1];
        int house2 = (int)(p1.getInv().getResource())[13][1];


        String[] itemList = new String[14];
        int i;
        int j = -1;
        itemList[0] = "stonesword";
        itemList[1] = "stoneaxe";
        itemList[2] = "stonepickaxe";
        itemList[3] = "ship0";
        itemList[4] = "ship1";
        itemList[5] = "ship2";
        itemList[6] = "house1";
        itemList[7] = "house2";
        itemList[8] = "house3";
        itemList[9] = "meat";
        itemList[10] = "fruits";
        itemList[11] = "water";
        itemList[12] = "smoke";
        itemList[13] = "sos";
        for(i=0; i<itemList.length; i++){
            if(makingItem.equals(itemList[i])) 
                j = i;
        }
       
        if(j == 0){
            if(wood >= 30 && stone >= 30) return 1;
            else return 0;
        }
        else if(j==1){
            if(wood >= 15 && stone >= 15) return 1;
            else return 0;
        }
        else if(j==2){
            if(wood >= 25 && stone >= 25) return 1;
            else return 0;
        }
        else if(j==3){
            if(wood >= 100 && stone >= 100) return 1;
            else return 0;
        }
        else if(j==4){
            if(wood >= 150 && stone >= 150 && ship0 >= 1) return 1;
            else return 0;
        }
        else if(j==5){
            if(wood >= 200 && stone >= 200 && ship1 >= 1) return 1;
            else return 0;
        }
        else if(j==6){
            if(wood >= 50 && stone >= 50 && house0 >= 1) return 1;
            else return 0;
        }
        else if(j==7){
            if(wood >= 75 && stone >= 75 && house1 >= 1) return 1;
            else return 0;
        }
        else if(j==8){
            if(wood >= 100 && stone >= 100 && house2 >= 1) return 1;
            else return 0;
        }
        else if(j==9){
            if(meat > 0) return 1;
            else return 0;
        }
        else if(j==10){
            if(fruits > 0) return 1;
            else return 0;
        }
        else if(j==11){
            if(water > 0) return 1;
            else return 0;
        }
        else if(j == 12){
            if(wood >= 30) return 1;
            else return 0;
        }
        else if(j == 13){
            if(stone >= 30) return 1;
            else return 0;
        }


        else return -1;

    }


    //현재 정보를 저장용 배열에 입력
    private String[][] _makeSaveData(){
        String[][] saveData = {
            {"water ", String.valueOf(this.p1.getInv().getResource()[0][1])},
            {"wood ",String.valueOf(this.p1.getInv().getResource()[1][1])},
            {"stone ",String.valueOf(this.p1.getInv().getResource()[2][1])},
            {"stonesword ",String.valueOf(this.p1.getInv().getResource()[3][1])},
            {"stoneaxe ",String.valueOf(this.p1.getInv().getResource()[4][1])},
            {"stonepickaxe ",String.valueOf(this.p1.getInv().getResource()[5][1])},
            {"meat ",String.valueOf(this.p1.getInv().getResource()[6][1])},
            {"fruits ",String.valueOf(this.p1.getInv().getResource()[7][1])},
            {"ship0 ",String.valueOf(this.p1.getInv().getResource()[8][1])},
            {"ship1 ",String.valueOf(this.p1.getInv().getResource()[9][1])},
            {"ship2 ",String.valueOf(this.p1.getInv().getResource()[10][1])},
            {"house0 ",String.valueOf(this.p1.getInv().getResource()[11][1])},
            {"house1 ",String.valueOf(this.p1.getInv().getResource()[12][1])},
            {"house2 ",String.valueOf(this.p1.getInv().getResource()[13][1])},
            {"house3 ",String.valueOf(this.p1.getInv().getResource()[14][1])},
            {"hunger ",Integer.toString(this.p1.getHunger())},
            {"thirst ",Integer.toString(this.p1.getThirst())},
            {"action ",Integer.toString(this.p1.getAction())},
            {"fatigue ",Integer.toString(this.p1.getFatigue())},
            {"days ",Integer.toString(this.days)}
        };

        System.out.println(saveData[0][1]);
        return saveData;
    }

    //읽어온 파일로부터 정보를 적용
    private void _useLoadData(String[][] loadData){
        int i = 0;
        for(i=1; i<= 15; i++){
            this.p1.getInv().setResource(Integer.parseInt(loadData[i][1]), i-1);
        }
        this.p1.setHunger(Integer.parseInt(loadData[16][1]));
        this.p1.setThirst(Integer.parseInt(loadData[17][1]));
        this.p1.setAction(Integer.parseInt(loadData[18][1]));
        this.p1.setFatigue(Integer.parseInt(loadData[19][1]));
        this.days = Integer.parseInt(loadData[20][1]);

    }

    //도움말 불러오기
    
    private void _help(String str){//help 했을때 실행되는 함수

       
        if(str.equals("gathering")){    //파일(txt)이용해서 help내용 가져오게 하는게 편할듯
            trd._readTxt("gathering");
        }else if(str.equals("command")){
            trd._readTxt("command");
        }else if(str.equals("escape")){
            trd._readTxt("escape");
        }else if(str.equals("inventory")){
            trd._readTxt("inventory");
        }else if(str.equals("item")){
            trd._readTxt("item");
        }else if(str.equals("player")){
            trd._readTxt("player");
        }else if(str.equals("gameexplain")){
            trd._readTxt("gameExplain");
        }else if(str.equals("save")){
            trd._readTxt("save");
        }else if(str.equals("savelist")){
            trd._readTxt("savelist");
        }else if(str.equals("load")){
            trd._readTxt("load");
        }
    }
}
