/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;

/**
 * fetch command retrieves data about a particular topic from the server
 * @author Arbaaz Zakir
 */
public class FetchCommand implements Command{
    //private CLFormatter helper;
    private SeeterModel model;
    /**
     * creates a new instance of a fetch command
     * @param model model passed to gets and sets data
     */
    public FetchCommand(SeeterModel model){
        this.model = model;
        
        
    }
    /**
     * executes fetch command retrieving data about a particular seet or 
     * topic data such as userid and body
     */
    @Override
    public void execute() {
        try{
          model.setStateMain();
          model.getCLFormatter().chan.send(new SeetsReq(model.getRawArgs()[0]));
          //model.setStateMain();
          SeetsReply rep = (SeetsReply) model.getCLFormatter().chan.receive();
          System.out.print(
              model.getCLFormatter().formatFetched(model.getRawArgs()[0], rep.users, rep.lines));
        }
        catch(Exception ex){
            throw new RuntimeException();
        }
     } 
    
}
