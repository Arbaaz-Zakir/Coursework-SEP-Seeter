/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

/**
 * shuts down the system
 * @author Arbaaz Zakir
 */
public class ExitCommand implements Command{
    private SeeterModel model;
    /**
     * create new instance of exit command
     * @param model 
     */
    public ExitCommand(SeeterModel model){
        this.model = model;
    }
    /**
     * executes system exit
     */
    @Override
    public void execute() {
        model.setStateTerminated();
        System.exit(0);
    }
    
}
