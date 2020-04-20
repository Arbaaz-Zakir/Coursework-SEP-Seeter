/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import sep.mvc.AbstractView;
import sep.seeter.net.message.Bye;
import sep.seeter.net.message.Publish;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;
/**
 * the view handles the UI aspects of the seeter system
 * @author Arbaaz Zakir
 */
public class SeeterView extends AbstractView{
    private static final String RESOURCE_PATH ="resources/MessageBundle";
    private final ResourceBundle strings;
//    String user = args[0];
//    String host = args[1];
//    int port = Integer.parseInt(args[2]);
    private BufferedReader reader;
    
    private SeeterController controller;
    //boolean printSplash = true;
    private SeeterModel model;
    private CLFormatter helper;
 
    //private String cmd;
    //private Command command;
    //private String[] rawArgs;
    /**
     * creates a new instance of a view
     * @param model 
     */
    public SeeterView(SeeterModel model){
        this.model = model;
        strings = ResourceBundle.getBundle(RESOURCE_PATH, new Locale("en", "GB"));
    }
    

    
    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * runs the view
     * @throws IOException 
     */
    @Override
    @SuppressFBWarnings(
      value = "DM_DEFAULT_ENCODING",
      justification = "When reading console, ignore default encoding warning")
    public void run() throws IOException {
        update();
    }
    /**
     * assigns the view the controller
     * @param controller 
     */
    public void setController(SeeterController controller){
        this.controller = controller;
    }
    /////////////////////////
//    public void splitInput(String raw){
//      List<String> split = Arrays.stream(raw.trim().split("\\ "))
//          .map(x -> x.trim()).collect(Collectors.toList());
//      cmd = split.remove(0);  // First word is the command keyword
//      rawArgs = split.toArray(new String[split.size()]);
//    }
    /**
     * reads user input by splitting the received input into the command
     * and arguments
     * @param reader -  takes user input stream
     * @throws IOException 
     */
    public void readUserInput(BufferedReader reader) throws IOException{
        //reader = new BufferedReader(new InputStreamReader(System.in));
       String raw = reader.readLine();
       // splitInput(raw);
       if(raw == null){
           throw new IOException(strings.getString("stream_closed"));
       }
      List<String> split = Arrays.stream(raw.trim().split("\\ "))
          .map(x -> x.trim()).collect(Collectors.toList());
      String cmd = split.remove(0);  // First word is the command keyword
      model.setCmd(cmd);
      String[] rawArgs = split.toArray(new String[split.size()]);
      model.setRawArgs(rawArgs);
      
    }
    //////////////////////////////////////////////////////////////////////
    /**
     * checks the system has been given a user and host then prints the welcome 
     * page
     */
    public void checkClient(){
        if (model.getClient().getUser().isEmpty() || model.getClient().getHost().isEmpty()) {
            System.err.println("User/host has not been set.");
            System.exit(1);
        }
        else{
            splashScreen();
        }
    }
    /**
     * prints welcome 'splash' screen
     */
    public void splashScreen(){
        if(model.isPrintSplash() == true){
            System.out.println(model.getCLFormatter().formatSplash(model.getClient().getUser()));
        }
    }
    /**
     * prints the users options depending on the state
     */
    public void printOptions(){
        if(model.getState() == State.MAIN){
            System.out.print(model.getCLFormatter().formatMainMenuPrompt());
          } 
        else {  // state = "Drafting"
        System.out.print(model.getCLFormatter().
            formatDraftingMenuPrompt(model.getDraftTopic(), model.getDraftLines()));
        }
    }  
    /**
     * executes a command that has been encapsulated
     * based on the user input stored in model
     */
    public void runCommand(){
        Command command = new CommandWords(model).getCommand(model.getCmd());
        command.execute();
    }
    /**
     * loops the view
     * @param helper CLFormatter
     * @param reader BuffereReader
     * @throws IOException 
     */
    public void loop(CLFormatter helper, BufferedReader reader) throws IOException{
        for(boolean done = false; !done;){
            printOptions();
            readUserInput(reader);
            runCommand();
        }
        
    }
    /**
     * gets the helper
     * @return CLFormatter helper
     */
    public CLFormatter getCLFormatter(){
        return helper;
    }
    /**
     * gets the reader
     * @return BufferedReafer reader
     */
     public BufferedReader getReader(){
        return reader;
    }   
    /**
     * updates the view depending on the state
     */
    @Override
    public void update() {
        printOptions();
    }
    
//    public void splash(){
//        if(m.printSplash = true){
//            System.out.println(helper.formatSplash((controller.getModel().getUser())));
//        }
//    }
    
//    @Override
//    public void init(){
//        view.setController();
//    }
    
    

}
