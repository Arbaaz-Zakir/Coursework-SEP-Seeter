/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * implements the command interface, adds text to a draft topic 
 * @author Arbaaz Zakir
 */
public class BodyCommand implements Command{
    
    private SeeterModel model;
    /**
     * create new instance of body command that adds to an array in model
     * @param model - takes model
     */
    public BodyCommand(SeeterModel model){
        this.model = model;
    }
    
    /**
     * executes the body command causing text to be added to the array
     */
    @Override
    public void execute() {
        model.setStateDrafting();
        String Line = Arrays.stream(model.getRawArgs()).
                collect(Collectors.joining());
        model.addDraftLines(Line);
        
    }
//    public void undo(){
//        if(model.getState() == State.DRAFTING){
//        model.addDraftLines(model.getDraftLines().
//                remove(model.getDraftLines().size() - 1));
//        }
//    }
}
