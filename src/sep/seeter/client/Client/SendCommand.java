/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import sep.seeter.net.message.Publish;

/**
 *
 * @author Arbaaz Zakir
 */
public class SendCommand implements Command{
    private SeeterModel model;
    private CLFormatter helper;
    public SendCommand(SeeterModel model){
        this.model = model;
        helper = new CLFormatter(model.getClient().getHost(), model.getClient().getPort());
    }
    @Override
    public void execute() {
        try{
           helper.chan.send(new Publish(model.getClient().getUser(), model.getDraftTopic(), model.getDraftLines()));
            model.setDraftTopic(null);
            model.setStateMain();
        }  
        catch (Exception ex){
            throw new RuntimeException();
        }
        
    }
    
}

