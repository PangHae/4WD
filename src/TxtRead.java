<<<<<<< HEAD
<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TxtRead{

    public void _readTxt(String command){

        command = command.toLowerCase() + ".txt";
        String txtPath = "./helpTxt/"+command;
=======
=======
>>>>>>> bd14f58a668209fef6d6d341d27959c3e9e07875
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class TxtRead {

    public void _readTxt(String command){
        command = command.toLowerCase();
        String txtPath = "./helpTxt/"+ command + ".txt";
<<<<<<< HEAD
>>>>>>> f3afa8943fff7dd5d75a290b423af4c64762886e
=======
>>>>>>> bd14f58a668209fef6d6d341d27959c3e9e07875
        try{
            File file = new File(txtPath);
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
<<<<<<< HEAD
<<<<<<< HEAD
        }catch(FileNotFoundException e){
=======
        }catch (FileNotFoundException e) {
>>>>>>> f3afa8943fff7dd5d75a290b423af4c64762886e
=======
        }catch (FileNotFoundException e) {
>>>>>>> bd14f58a668209fef6d6d341d27959c3e9e07875

        }
    }
}
