package Exceptions;

public class IncorrectDataInput extends RuntimeException{
    public IncorrectDataInput(){
        super();
    }
    public IncorrectDataInput(String s){
        super(s);
    }
}

