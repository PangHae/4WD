import javax.swing.*;
import java.util.*;

public class Commands {
    private String rowCmd = null;
    private String[] blockCmd;
    private Scanner inputScanner;

    Commands(){
        this.inputScanner = new Scanner(System.in);
    }


    public String[] _inputCommand(){
        while(true){

            System.out.print("input Command: ");
            this.rowCmd = this.inputScanner.nextLine().toLowerCase();

            _cleaning(rowCmd.split("\\s+"));
            if(blockCmd[0].equals("help")){
                //help 함수
            }else if(blockCmd !=null){
                return this.blockCmd;
            }
        }
    }

    private void _cleaning(String[] str){

        if(str[0].equals("") || str.length>3){ //처음 공백 or 길이 3 보다 클경우 예외 처리
            this.blockCmd=null;
        }else if(str.length<=3 && str[0] !=null){ //명령어 들어가는 경우
            this.blockCmd=str;
        }else{
            this.blockCmd=null;
        }

    }

    private void _checksplit(){
        String[] temp=null;

        if(blockCmd[0] == null){
            temp[0] = blockCmd[1];
            temp[1] = blockCmd[2];
            blockCmd=null;
            blockCmd=temp;
        }
    }

//    test
//    public void _commandTest() {
//        System.out.println(this.rowCmd);
//        if (this.blockCmd != null) {
//            for (int Rep1 = 0; Rep1 < blockCmd.length; Rep1++)
//                System.out.println(Rep1 + " : " + this.blockCmd[Rep1]);
//        }else
//            System.out.println("null");
//    }

}
