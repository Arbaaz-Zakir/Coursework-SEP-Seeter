/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import sep.mvc.AbstractModel;
/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterModel extends AbstractModel{
    //enum States{MAIN, DRAFTING, TERMINATED}
    private String[] rawArgs;
    String cmd;
    
    private String user;
    private String host;
    private int port;
    private State state = State.MAIN;
    //Client client;
    
    String draftTopic;
    List<String> draftLines = new LinkedList<>();
    
//    public SeeterModel(Client client){
//        this.client = client;
//    }
    //view
    public void set(String user, String host, int port) {
        this.user = user;
        this.host = host;
        this.port = port;
    }
  
    public State getState(){
        return state;
    }
    
    public String getUser(){
        return user;
    }
    
    public String getHost(){
        return host;
    }
    
    public int getPort(){
        return port;
    }
    // states
    public void setStateDrafting(){
        state = State.DRAFTING;
    }
    
    public void setStateMain(){
        state = State.MAIN;
    }
    
    public void setStateTerminated(){
        state = State.TERMINATED;
    }
    
    public void addDraftLines(String lines){
        draftLines.add(lines);
    }
    public List <String> getDraftLines(){
        return draftLines;
    }    
    public String getDraftTopic(){
        return draftTopic;
    }
    public void setDraftTopic(String draftTopic){
        this.draftTopic = draftTopic;
    }
//    public void addArgs(String args){
//        this.args = args;
//    }
    
    public void splitInput(String raw){
      List<String> split = Arrays.stream(raw.trim().split("\\ "))
          .map(x -> x.trim()).collect(Collectors.toList());
      cmd = split.remove(0);  // First word is the command keyword
      rawArgs = split.toArray(new String[split.size()]);
    }
    public String getCmd(){
        return cmd;
    }
    public String[] getRawArgs(){
        return rawArgs;
    }
}
