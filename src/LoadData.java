
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
/*
    세이브 사용법 >
    1. 세이브할 데이터들을 모아 String 2차원배열로 만든다. String[][] str = ....
    2. 그 배열을 setdata에 집어넣는다. _setdata(str)
    3. 세이브할 데이터 파일 이름을 지정한다 _setlocation(name)
    4. 세이브 시킨다 _save()

    로드 사용법 >
    1. 받을 2차원 String배열을 만든다. String[][] str
    2. 로드할 데이터 파일 이름을 지정한다. _setlocation(name)
    3. 데이터를 str배열에 로드한다 str = _load()

    추가 참고 사항 >
    1. 데이터를 공백문자 기준으로 자르기 때문에, 반드시 형식을 맞춰 주어야 한다.
    1-1. 그 형식은 _test()내부에 있으니, 확인하길 바란다.
    2. 데이터를 로드하면 첫번째 행은 저장일이 들어간다. str[0][0], str[0][1]
    3. 데이터가 String이므로, ParseInt로 바꿔 쓸 것.
    4. 필드 리셋은 _reset()을 사용할 것.
<<<<<<< HEAD
* */
=======
    5. 세이브 파일 목록은 _showlist()를 사용할 것.
*/
>>>>>>> bd14f58a668209fef6d6d341d27959c3e9e07875

public class LoadData {
    private String cmd = null;
    private String loadlocation = null;
    private String data = null;
    private Queue<String> queue = new LinkedList<>();

    LoadData(){

    }

    private String _makeform(String[][] str){
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm");
        Date time = new Date();
        String form = format.format(time);
        form += "\n";
        for(int Rep1=0;Rep1<str.length;Rep1++){
            for(int Rep2=0;Rep2<str[Rep1].length;Rep2++){
                form += str[Rep1][Rep2];
                if(Rep2%2==1) form += "\n";
            }
        }
        return form;
    }

    public void _setdata(String[][] data){
        this.data = _makeform(data);
    }
    public void _setlocation(String location){
        this.loadlocation = location;
    }

    public void _reset(){
        this.loadlocation = null;
        this.cmd = null;
    }
//test
    public void _test(){
        String[][] test = {
                {"data ","1"},
                {"data2 ","2"},
                {"data3 ","3"},
                {"data4 ","4"},
                {"hunger ","1"},
                {"days ","3"},
                {"test ","4"},
                {"teee ","33"},
                {"gwent ","good"},
                {"hearthstone ","garbage"}
        };
        _setlocation("test5");
        //_setdata(test);
        //_save();
        _showlist();
        String[][] str2 =_load();
        _showarr(str2);
    }

    public void _showarr(String[][] str){
        try {
            for (int Rep1 = 0; Rep1 < str.length; Rep1++) {
                for (int Rep2 = 0; Rep2 < str[Rep1].length; Rep2++) {
                    System.out.println("str[" + Rep1 + "][" + Rep2 + "]: " + str[Rep1][Rep2]);
                }
            }
        }catch (Exception e){
            if(e.getClass().getSimpleName().equals("NullPointerException")){
                System.out.println("You are finding something in Null. try it again.");
            }
        }
    }

    //show save lists
    private void _showlist(){
        File path = new File("./Data/");
        File[] lists = path.listFiles();
        System.out.println("--Save Lists--");
        for(int Rep1=0;Rep1<lists.length;Rep1++){
            System.out.println(lists[Rep1]);
        }
        System.out.println("--Save Lists End--");
    }

    private void _save(){
        byte tdata[] = this.data.getBytes();
        try{
            FileOutputStream outstreams = new FileOutputStream("./Data/"+this.loadlocation+".txt");

            outstreams.write(tdata);
            outstreams.close();

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("saved");
        }

    }

    private String[][] _load(){

        int Rep1=0;
        try{
            FileInputStream readstreams = new FileInputStream("./Data/"+this.loadlocation+".txt");
            InputStreamReader reads = new InputStreamReader(readstreams,"utf-8");
            BufferedReader read = new BufferedReader(reads);

            String data = read.readLine();

            while(data != null){
<<<<<<< HEAD
                System.out.println(data);
=======
>>>>>>> bd14f58a668209fef6d6d341d27959c3e9e07875
                String[] str = data.split("\\s+");
                data = read.readLine();
                this.queue.offer(str[0]);
                this.queue.offer(str[1]);
                ++Rep1;
            }
            String[][] loaddata = new String[Rep1][2];

            for(int Rep3=0;Rep3<Rep1;Rep3++){
                loaddata[Rep3][0] = this.queue.poll();
                loaddata[Rep3][1] = this.queue.poll();
            }
            _cleanqueue();
            readstreams.close();
            reads.close();
            read.close();
            System.out.println("Read complete");
            return loaddata;
        }catch(Exception e){
            if(e.getClass().getSimpleName().equals("FileNotFoundException")){
                System.out.println("this file is not exist. plz check the name");
            }else if(e.getClass().getSimpleName().equals("NullPointerException")){
                System.out.println("You are finding something in Null. try it again.");
            }else{
                System.out.println("Unknown Execptions!");
            }
            return null;
        }finally{
            System.out.println("End Reading");
        }
    }

    //Queue
    private void _cleanqueue(){
        this.queue.clear();
    }
}
