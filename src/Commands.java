import javax.swing.*;
import java.util.*;

public class Commands {
    private String rowCmd = null;
    private String[] blockCmd;
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

<<<<<<< HEAD
    private String[] helpList={"gathering","command","escape","gameExplain","inventory","item","player"};
=======
    private String[] helpList={"gathering","make","use","rescue","sleep","escape"};
>>>>>>> a97d50c87b8e433e20d0d99d4c00e452bd5d5842

    Commands(){
        this.inputScanner = new Scanner(System.in);
    }


    public String[] _inputCommand(){
        while(true){

            System.out.print("input Command: ");
            this.rowCmd = this.inputScanner.nextLine().toLowerCase();

            _cleaning(rowCmd.split("\\s+"));

            if(blockCmd[0].equals("help")){

                if(blockCmd.length!=1){
                    System.out.println("??");
                    for(int i=0;i<helpList.length;i++){
                        if(blockCmd[1].equals(helpList[i])){
                            _help(blockCmd[1]);
                            System.out.println("help list입력시");
                            return null;
                        }
                    }
                }else if(blockCmd.length==1){
                    _help("");
                    System.out.println("help만 입력시");
                    return null;
                }

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

<<<<<<< HEAD
    private void _help(String str){//help 했을때 실행되는 함수

        TxtRead rd = new TxtRead();
        if(str.equals("gathering")){    //파일(txt)이용해서 help내용 가져오게 하는게 편할듯
            rd._readTxt("gathering");
        }else if(str.equals("command")){
            rd._readTxt("command");
        }else if(str.equals("escape")){
            rd._readTxt("escape");
        }else if(str.equals("gameExplain")){
            rd._readTxt("gameExplain");
        }else if(str.equals("inventory")){
            rd._readTxt("inventory");
        }else if(str.equals("item")){
            rd._readTxt("item");
        }else if(str.equals("player")){
            rd._readTxt("player");
=======
    private void _help(String str){     //help 했을때 실행되는 함수
        if(str.equals("gathering")){    //파일(txt)이용해서 help내용 가져오게 하는게 편할듯

        }else if(str.equals("make")){

        }else if(str.equals("use")){

        }else if(str.equals("rescue")){

        }else if(str.equals("sleep")){

        }else if(str.equals("escape")){

        }else if(str.equals("")){

>>>>>>> a97d50c87b8e433e20d0d99d4c00e452bd5d5842
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
