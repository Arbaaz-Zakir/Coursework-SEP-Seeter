package sep.client;


import sep.seeter.net.channel.ClientChannel;
import sep.seeter.net.message.Message;
import sep.client.CLFormatter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arbaaz Zakir
 */
public class Send implements Command {
    Message message;
    public Send(Message message){
        this.message = message;
    }
    @Override
    public void execute() {
        //send(message);
    }
    
}
