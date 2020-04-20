/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
/**
 * 
 * @author Arbaaz Zakir
 */
public class CommandWords {
    private Map<String, Command> commands = new HashMap<>(); 
    private static final String RESOURCE_PATH ="resources/MessageBundle";
    private final ResourceBundle strings;
   
    //dangerous comeback to this
    private SeeterModel model;

    public CommandWords(SeeterModel m){
        strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
        commands.put(strings.getString("exit_cmd"), new ExitCommand(m));
        commands.put(strings.getString("fetch_cmd"), new FetchCommand(m));
        commands.put(strings.getString("body_cmd"), new BodyCommand(m));
        commands.put(strings.getString("send_cmd"), new SendCommand(m));
        commands.put(strings.getString("compose_cmd"), new ComposeCommand(m));
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
