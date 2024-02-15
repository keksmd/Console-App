package Commands;

import Main.Command;
import utilites.interfaces.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exexute extends Command implements methods{
    final String fileName;
    public Exexute(String fileName){
        this.fileName = fileName;

    }
    public boolean calling(){
        File file = new File(fileName);
        if(file.exists()){
            Scanner fileContent;
            try {
                fileContent = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            boolean flag = false;
            while(fileContent.hasNextLine()){
                if(!new Command().commandReader(new Scanner(fileContent.nextLine()).nextLine()).getCmd().calling()){
                    new NotFound().calling();
                }else {
                    flag = true;
                }
            }
            return flag;
        }else{
            System.out.println("There is no file with choosen name");
            return false;
        }
    }
}
