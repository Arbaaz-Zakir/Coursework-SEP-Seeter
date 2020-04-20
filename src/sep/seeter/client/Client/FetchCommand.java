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
 *
 * @author Arbaaz Zakir
 */
public class FetchCommand implements Command{
    //private CLFormatter helper;
    private SeeterModel model;
    
    public FetchCommand(SeeterModel model){
        this.model = model;
        
        
    }
    
    @Override
    public void execute() {
        try{
          model.getCLFormatter().chan.send(new SeetsReq(model.getRawArgs()[0]));
          SeetsReply rep = (SeetsReply) model.getCLFormatter().chan.receive();
          System.out.print(
              model.getCLFormatter().formatFetched(model.getRawArgs()[0], rep.users, rep.lines));
        }
        catch(Exception ex){
            throw new RuntimeException();
        }
     } 
    
}
