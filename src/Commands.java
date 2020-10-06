import javax.swing.*;
import java.util.*;

public class Commands {
    private String rowCmd = null;
    private String[] blockCmd;
    private String[] saveFileName= new String[2];
    private Scanner inputScanner;
//    private String[][] possible = {
//            {"gathering","wood","stone","meat","fruits","water"},
//            {"make","stonesword","stonepickaxe","ship0","ship1","ship2","house1","house2","house3"},
//            {"use","meat","fruits","water"},
//            {"rescue","smoke","sos"},
//            {"help"},
//            {"sleep"},
//            {"escape"}
//    };


    private String[] helpList={"gathering","command","escape","gameexplain","inventory","item","player"};


    Commands(){
        this.inputScanner = new Scanner(System.in);
    }


    public String[] _inputCommand(){
        while(true){

            System.out.print("input Command: ");
            this.rowCmd = this.inputScanner.nextLine().toLowerCase();

            _cleaning(rowCmd.split("\\s+"));
            if(blockCmd != null) { // 재우 : null 예외처리

                if (blockCmd[0].equals("help")) {

                    if (blockCmd.length != 1) {
                        System.out.println("??");
                        for (int i = 0; i < helpList.length; i++) {
                            if (blockCmd[1].equals(helpList[i])) {
                                _help(blockCmd[1]);
                                System.out.println("help list입력시");
                                return null;
                            }
                        }
                    } else if (blockCmd.length == 1) {
                        TxtRead read = new TxtRead();
                        System.out.println("help만 입력시");
                        read._readTxt("help");
                        return null;
                    }

                }else if (blockCmd[0].equals("save")){   // 재우 : 기ㅈㄴ blockcmd처럼 String배열이용해서 내용 보냄 savefileName에서 0인덱스ㅡ save 1인덱스는 입력값
                    System.out.println("Write the save file name that you want : ");
                    rowCmd = inputScanner.nextLine();
                    saveFileName[0]=blockCmd[0];
                    saveFileName[1]=rowCmd;
                    System.out.println(saveFileName[0]+" "+saveFileName[1]);
                    return saveFileName;

                }else if (blockCmd != null ) {  // 재우 : 명령어 길이 확인 및 제대로 들어가는 경우만 되게 함
                    return this.blockCmd;
                }

            }else{
                return null;
            }

        }
    }

    private void _cleaning(String[] str){

        if(str[0].equals("") || str.length>=3){ //처음 공백 or 길이 3 보다 클경우 예외 처리
            this.blockCmd=null;
        }else if(str.length<3 && str[0] !=null){ //명령어 들어가는 경우
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

    private void _help(String str){//help 했을때 실행되는 함수

        TxtRead rd = new TxtRead();
        if(str.equals("gathering")){    //파일(txt)이용해서 help내용 가져오게 하는게 편할듯
            rd._readTxt("gathering");
        }else if(str.equals("command")){
            rd._readTxt("command");
        }else if(str.equals("escape")){
            rd._readTxt("escape");
        }else if(str.equals("inventory")){
            rd._readTxt("inventory");
        }else if(str.equals("item")){
            rd._readTxt("item");
        }else if(str.equals("player")){
            rd._readTxt("player");
        }else if(str.equals("gameexplain")){
            rd._readTxt("gameExplain");
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
