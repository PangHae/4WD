import java.util.*;

public class Commands {
    private String rowCmd = null;
    private String[] blockCmd;
    private Scanner inputScanner;

    Commands(){
        this.inputScanner = new Scanner(System.in);
    }


    public String[] _inputCommand(){
        System.out.print("input Command: ");
        this.rowCmd = this.inputScanner.nextLine();
        _cleaning(rowCmd.split("\\s+"));
        return this.blockCmd;
    }

    private void _cleaning(String[] str){
        if(str[0] == null || str.length>3){
            this.blockCmd=null;
        }else
            this.blockCmd=str;
    }

    //test
    public void _commandTest() {
        System.out.println(this.rowCmd);
        if (this.blockCmd != null) {
            for (int Rep1 = 0; Rep1 < blockCmd.length; Rep1++)
                System.out.println(Rep1 + " : " + this.blockCmd[Rep1]);
        }else
            System.out.println("null");
    }

}
