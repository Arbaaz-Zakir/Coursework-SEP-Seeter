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
 * model deals with backend logic
 * @author Arbaaz Zakir
 */
public class SeeterModel{
    private String[] rawArgs;
    private CLFormatter helper;
    private BufferedReader reader;
    private String cmd;
    private Client client;

    private State state = State.MAIN;
    //Client client;
    private boolean printSplash = true;
    String draftTopic;
    List<String> draftLines = new LinkedList<>();
    
    /**
     * creates a new model 
     * @param client- client sets the user, host, and port
     */
    public SeeterModel(Client client){
        this.client = client;
    }
//    view
//    public void set(String user, String host, int port) {
//        this.user = user;
//        this.host = host;
//        this.port = port;
//    }
    /**
     * gets state
     * @return - return enum state
     */
    public State getState(){
        return state;
    }
    /**
     * gets the client
     * @return - return client assigned to model on creation
     */
    public Client getClient(){
        return client;
    }

    /**
     * sets state to drafting
     */
    public void setStateDrafting(){
        state = State.DRAFTING;
    }
    /**
     * sets state to main
     */
    public void setStateMain(){
        state = State.MAIN;
    }
    /**
     * sets state to terminated
     */
    public void setStateTerminated(){
        state = State.TERMINATED;
    }
    /**
     * adds draft lines to list
     * @param lines - string lines added to a list 
     */
    public void addDraftLines(String lines){
        draftLines.add(lines);
    }
    /**
     * gets the draft lines
     * @return - list of draft lines
     */
    public List <String> getDraftLines(){
        return draftLines;
    }    
    /**
     * gets the draft topic
     * @return - String draft topic
     */
    public String getDraftTopic(){
        return draftTopic;
    }
    /**
     * sets the draft topic
     * @param draftTopic sets draft topic as a string
     */
    public void setDraftTopic(String draftTopic){
        this.draftTopic = draftTopic;
    }
//    public void addArgs(String args){
//        this.args = args;
//    }
    /**
     * gets the CLFormatter
     * @return CLFormatter 
     */
    public CLFormatter getCLFormatter(){
        return helper;
    }
    /**
     * gets the reader 
     * @return BufferedReader
     */
     public BufferedReader getReader(){
        return reader;
    }
     /**
      * sets a reader
      * @param reader takes a buffered reader
      */
     public void setReader(BufferedReader reader){
        this.reader = reader;
    }
     /**
      * returns the inputted command 
      * @return String command inputted by user
      */
    public String getCmd(){
        return cmd;
    }
    /**
     * gets the raw arguments inputted as array
     * @return String array of input arguments
     */
    public String[] getRawArgs(){
        String[] middle = rawArgs;
        return middle;
    }
    /**
     * sets the arguments in rawArgs
     * @param rawArgs String array of raw arguments
     */
    public void setRawArgs(String[] rawArgs){
        this.rawArgs = Arrays.copyOf(rawArgs, rawArgs.length);
    }  
    /**
     * sets the command inputted
     * @param cmd String command
     */
    public void setCmd(String cmd){
        this.cmd = cmd;
    }
    /**
     * returns the splash boolean
     * @return true
     */
    public boolean isPrintSplash() {
        return printSplash;
    }
    /**
     * empties list of draftLines
     */
    public void clearDraftLines(){
        draftLines.clear();
    }
    /**
     * sets the print splash
     * @param printSplash start menu with name etc.
     */
//    public void setPrintSplash(boolean printSplash) {
//        this.printSplash = printSplash;
//    }
    
    
    
}
