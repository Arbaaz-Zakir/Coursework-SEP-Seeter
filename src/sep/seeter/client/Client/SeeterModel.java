/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import sep.mvc.AbstractModel;
/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterModel{
    //enum States{MAIN, DRAFTING, TERMINATED}
    private String[] rawArgs;
    private CLFormatter helper;
    private BufferedReader reader;
    private String cmd;
    private Client client;
//    private String user;
//    private String host;
//    private int port;
    private State state = State.MAIN;
    //Client client;
    private boolean printSplash = true;
    String draftTopic;
    List<String> draftLines = new LinkedList<>();
    
    
    public SeeterModel(Client client){
        this.client = client;
    }
//    view
//    public void set(String user, String host, int port) {
//        this.user = user;
//        this.host = host;
//        this.port = port;
//    }
  
    public State getState(){
        return state;
    }
    public Client getClient(){
        return client;
    }
//    
//    public String getUser(){
//        return user;
//    }
//    
//    public String getHost(){
//        return host;
//    }
//    
//    public int getPort(){
//        return port;
//    }
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
    
    public CLFormatter getCLFormatter(){
        return helper;
    }
     public BufferedReader getReader(){
        return reader;
    }
     public void setReader(BufferedReader reader){
        this.reader = reader;
    }
    public String getCmd(){
        return cmd;
    }
    public String[] getRawArgs(){
        return rawArgs;
    }
    public void setRawArgs(String[] rawArgs){
        this.rawArgs = rawArgs;
    }  
    public void setCmd(String cmd){
        this.cmd = cmd;
    }

    public boolean isPrintSplash() {
        return printSplash;
    }

    public void setPrintSplash(boolean printSplash) {
        this.printSplash = printSplash;
    }
    
    
    
}
