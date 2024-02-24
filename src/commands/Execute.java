package commands;

import main.CollectionManager;
import utilites.interfaces.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Execute extends CollectionManager implements methods{

    final String fileName;
    public Execute(String fileName){
        this.fileName = fileName;

    }
    public boolean calling(){
        File file = new File(fileName);
        if(file.exists()){
            boolean flag = false;
            if (!CollectionManager.getWasExecuted().add(fileName)){
                System.err.println("Ах ты шалунишка,не стоит делать рекурсионный вызов комманд, рекурсия была проинорирована");
            }else {
                Scanner fileContentScanner;
                try {
                    fileContentScanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                while (fileContentScanner.hasNextLine()) {
                    var line = fileContentScanner.nextLine();
                    if (!line.equals("execute_script " + this.fileName)) {
                        if (!new CollectionManager().commandReader(line).getCmd().calling()) {
                            new NotFound().calling();
                        } else {
                            flag = true;
                        }
                    } else {
                        System.err.println("Ах ты шалунишка,не стоит делать рекурсионный вызов комманд, рекурсия была проинорирована");
                    }
                }
            }
            return flag;

        }else{
            System.out.println("There is no file with choosen name");
            return false;
        }
    }
}
