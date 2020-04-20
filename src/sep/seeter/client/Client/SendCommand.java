/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import sep.seeter.net.message.Publish;

/**
 * implements command to send seets
 * @author Arbaaz Zakir
 */
public class SendCommand implements Command{
    private SeeterModel model;
    private CLFormatter helper;
    /**
     * creates a new instance of the send command
     * @param model SeeterModel model
     */
    public SendCommand(SeeterModel model){
        this.model = model;
        helper = new CLFormatter(model.getClient().getHost(), model.getClient().getPort());
    }
    /**
     * executes the command send a composed seet with a body to the server
     */
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

