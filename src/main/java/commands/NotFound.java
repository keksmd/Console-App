package commands;

import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class NotFound extends Command implements methods{
    @Override
    public String toString() {
        return super.toString();
    }
    public Response calling(String[] a){
        Response resp = super.calling(a);
        resp.addMessage("Unknown command,try again or use 'help' toget information about aviable commands");
        resp.setSuccess(false);
        return resp;
    }
    private String name = "not_found";

}
