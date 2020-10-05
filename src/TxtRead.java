import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class TxtRead {

    public void _readTxt(String command){
        command = command.toLowerCase();
        String txtPath = "./helpTxt/"+ command + ".txt";
        System.out.println(txtPath);
        try{
            File file = new File(txtPath);
            
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        }catch (FileNotFoundException e) {

        }
    }
}
