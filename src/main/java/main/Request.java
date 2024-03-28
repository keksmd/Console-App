package main;

import commands.Add;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class Request extends Message{
    public Request(){

    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("***** "+this.getClass()+" Details *****\n");
        for(Field f: this.getClass().getFields()){
            try {
                f.setAccessible(true);
                s.append(f.getName()).append("=").append(f.get(this).toString()).append("\n");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        s.append("*****************************");

        return s.toString();
    }
    Command commandToExecute;
    public Command getCommandToExecute() {
        return commandToExecute;
    }

    public void setCommandToExecute(Command commandToExecute) {
        this.commandToExecute = commandToExecute;
    }

}
