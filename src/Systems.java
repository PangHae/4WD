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
                p1._showInventory();
                p1._showStatus();
                if(action == 1){
                    _nextDay();
                    System.out.println(this.days + "day");                    
                }
            }else{
                _newGame();
                break;
            }
        }
        
    }

    private void _newGame(){
        System.out.println("-GameOver-");
    }

    private void _setPlayers(){
        this.cmd = new Commands();
        Inventory inv = new Inventory(0,0,0,0,0,0,0);
        this.p1 = new Player(10,10,10,inv,10);
        
    }

    private boolean _isNotFinished(){
        if(this.days>=this.maximumDays) return false;
        else return true;
    }

    private void _nextDay(){
        this.days+=1;
    }

    //command 해석해서 리턴
    private int _interpretCommand(){

        if(this.blockCmd[0].equals("gathering")){
            if(this.blockCmd[1].equals("wood")) return 0;
            else if(this.blockCmd[1].equals("stone")) return 1;
            else if(this.blockCmd[1].equals("meet")) return 2;
            else if(this.blockCmd[1].equals("fruits")) return 3;
            else return -2;
        }
        else if(this.blockCmd[0].equals("make")){
            if(this.blockCmd[1].equals("stoneSword")) return 10;
            else if(this.blockCmd[1].equals("stoneAxe")) return 11;
            else if(this.blockCmd[1].equals("stonePickAx")) return 12;
            else return -2;
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
            System.out.println("gathering wood!!");
            if(currentAction >= 1){
                interaction._gathering("wood", 100, 1, 3, 1);
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 1){
            System.out.println("gathering stone!!");
            if(currentAction >= 1){
                
                interaction._gathering("stone", 100, 1, 3, 1);
            }
            else{
                System.out.println(notEnoughAction);
            }
        }
        else if(command == 2){
            System.out.println("gathering meet!!");
            if(currentAction >= 1){
                interaction._gathering("meet", 100, 1, 3, 1);
            }
            else{
                System.out.println(notEnoughAction);
            }

        }
        else if(command == 3){
            System.out.println("gathering fruits");
            if(currentAction >= 1){
                interaction._gathering("fruits", 100, 1, 3, 1);
            }
            else{
                System.out.println(notEnoughAction);
            }
        }

        else if(command == 10){
            System.out.println("make stoneSword!!");

        }
        else if(command == 11){
            System.out.println("make stoneAxe!!");

        }
        else if(command == 12){
            System.out.println("make stonePickAx!!");

        }
        else{
            System.out.println("error!!");
        }

    }

    //남은 행동력 계산
    private int _checkAction(){

        int currentAction = this.p1.getAction();

        if(currentAction == 0){
            this.p1.setAction(10);
            return 1;
        }
        else{
            return 0;
        }

    }
}
