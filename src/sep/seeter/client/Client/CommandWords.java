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
 * a collection of all commands that are currently usable by a user
 * 
 * @author Arbaaz Zakir
 */
public class CommandWords {
    private Map<String, Command> commands = new HashMap<>(); 
    private static final String RESOURCE_PATH ="resources/MessageBundle";
    private final ResourceBundle strings;
   
    //dangerous comeback to this
    private SeeterModel model;
    /**
     * creates a new instance of a command whenever called
     * @param m takes in model to allow executes to change the model
     */
    public CommandWords(SeeterModel m){
        strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
        commands.put(strings.getString("exit_cmd"), new ExitCommand(m));
        commands.put(strings.getString("fetch_cmd"), new FetchCommand(m));
        commands.put(strings.getString("body_cmd"), new BodyCommand(m));
        commands.put(strings.getString("send_cmd"), new SendCommand(m));
        commands.put(strings.getString("compose_cmd"), new ComposeCommand(m));
    }
    
    /**
     * retrieves a command whose key matches the inputted string
     * @param cmd user inputted command as a string to then return a command
     * @return returns a corresponding command whose key matches the inputted string
     */
    public Command getCommand (String cmd){
        return commands.get(cmd);
    }
    /**
     * checks if command is valid
     * @param cmd cmd is inputted string
     * @return true if command matches another key of a command
     */
    public boolean isValidCmd(String cmd){
        return commands.containsKey(cmd);
    }
    /**
     * lists all commands
     * @return String list of all commands
     */
    public String listCommands(){
        String cmdList = "";
        for(String s: commands.keySet()){
            cmdList += s + "\n";
        }
        return cmdList;
    }
}
