/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

/**
 * creates a new draft topic which strings can be attached via other commands
 * @author Arbaaz Zakir
 */
public class ComposeCommand implements Command{
    private SeeterModel model;
    /**
     * creates a new compose command
     * @param model model sets and holds data about the new topic
     */
    public ComposeCommand(SeeterModel model){
        this.model = model;
    }
    /**
     * executes the compose command creating a new topic  
     */
    @Override
    public void execute() {
         model.setStateDrafting();
         model.setDraftTopic(model.getRawArgs()[0]);
    }
    
}
