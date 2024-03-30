package commands;

import main.Command;
import main.Response;
import utilites.interfaces.methods;

public class NotFound extends Command implements methods{
    public Response calling(String[] a){
        Response resp = super.calling(a);
        resp.addMessage("Unknown command,try again or use 'help' toget information about aviable commands");
        resp.setSuccess(false);
        return resp;
    }
    private final String name = "not_found";

}
