package exceptions;

public class IncorrectDataInput extends Error{
    public IncorrectDataInput(){
        super();
    }
    public IncorrectDataInput(String s){
        super(s);
    }
}

