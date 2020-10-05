import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtRead{

    public void _readTxt(String command){

        command = command.toLowerCase() + ".txt";
        String txtPath = "./helpTxt/"+command;
        try{
            File file = new File(txtPath);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        }catch(FileNotFoundException e){

        }
    }
}
