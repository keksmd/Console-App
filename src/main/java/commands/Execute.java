package commands;

import main.CollectionManager;
import main.Command;
import main.Response;
import utilites.interfaces.methods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Execute extends Command implements methods{

    final String fileName;
    public Execute(String fileName){
        this.fileName = fileName;

    }
    public Response calling(String[] a){
        Response resp = super.calling(a);
        File file = new File(fileName);
        if(file.exists()){
            boolean flag = false;
            if (!CollectionManager.getWasExecuted().add(fileName)){
                resp.addMessage("Ах ты шалунишка,не стоит делать рекурсионный вызов комманд, рекурсия была проинорирована");
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
                    } else {
                        System.err.println("Ах ты шалунишка,не стоит делать рекурсионный вызов комманд, рекурсия была проинорирована");
                    }
                }
            }
            resp.setSuccess(flag);
            return resp;

        }else{
            System.out.println("There is no file with choosen name");
            resp.setSuccess(false);
            return resp;
        }
    }
    private final String name = "execute";
}
