/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Arbaaz Zakir
 */
public class CommandWords {
    private Map<String, Command> commands = new HashMap<>(); 
    
    private SeeterModel model;
    public CommandWords(){
        commands.put("exit", new ExitCommand());
        commands.put("fetch", new FetchCommand(model));
    }
    
    public Command getCommand (String cmd){
        return commands.get(cmd);
    }
    
    public boolean isValidCmd(String cmd){
        return commands.containsKey(cmd);
    }
    
    public String ListCommands(){
        String cmdList = "";
        for(String s: commands.keySet()){
            cmdList += s + "\n";
        }
        return cmdList;
    }
}
