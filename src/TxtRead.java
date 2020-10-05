<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtRead{

    public void _readTxt(String command){

        command = command.toLowerCase() + ".txt";
        String txtPath = "./helpTxt/"+command;
=======
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class TxtRead {

    public void _readTxt(String command){
        command = command.toLowerCase();
        String txtPath = "./helpTxt/"+ command + ".txt";
>>>>>>> f3afa8943fff7dd5d75a290b423af4c64762886e
        try{
            File file = new File(txtPath);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
<<<<<<< HEAD
        }catch(FileNotFoundException e){
=======
        }catch (FileNotFoundException e) {
>>>>>>> f3afa8943fff7dd5d75a290b423af4c64762886e

        }
    }
}
