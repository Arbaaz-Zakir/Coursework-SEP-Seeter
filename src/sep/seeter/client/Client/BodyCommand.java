/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author Arbaaz Zakir
 */
public class BodyCommand implements Command{
    
    private SeeterModel model;

    public BodyCommand(SeeterModel model){
        this.model = model;
    }
    @Override
    public void execute() {
        String Line = Arrays.stream(model.getRawArgs()).
                collect(Collectors.joining());
        model.addDraftLines(Line);
        
    }
}
