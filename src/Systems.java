public class Systems {
    private int days=1;
    private int maximumDays;
    private int times;
    private Commands cmd;
    private Player p1;
    private String[] blockCmd;

    Systems(int maximumDays,int times){
        this.maximumDays = maximumDays;
        this.times= times;
    }

    public void _dayGame(){
        _setPlayers();

        if(_isNotFinished()){
            this.blockCmd = this.cmd._inputCommand();
            this.cmd._commandTest();
            _nextDay();
        }else{
            _newGame();
        }
    }

    private void _newGame(){
        System.out.println("-GameOver-");
    }

    private void _setPlayers(){
        this.cmd = new Commands();
        Inventory inv = new Inventory();
        this.p1 = new Player(10,10,10,inv);
    }

    private boolean _isNotFinished(){
        if(this.days>=this.maximumDays) return false;
        else return true;
    }

    private void _nextDay(){
        this.days+=1;
    }

}
