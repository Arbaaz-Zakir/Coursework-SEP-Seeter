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
import java.util.stream.Collectors;
import sep.mvc.AbstractView;
import sep.seeter.net.message.Bye;
import sep.seeter.net.message.Publish;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;
/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterView extends AbstractView{
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
    public SeeterView(SeeterModel model){
        this.model = model;
    }
    
    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @SuppressFBWarnings(
      value = "DM_DEFAULT_ENCODING",
      justification = "When reading console, ignore default encoding warning")
    public void run() throws IOException {
        
        update();
        
    }
        
        
/**
//        BufferedReader reader = null;
//        CLFormatter helper = null;
//        try {
//            reader = new BufferedReader(new InputStreamReader(System.in));
//
//        if (model.getUser().isEmpty() || model.getHost().isEmpty()) {
//            System.err.println("User/host has not been set.");
//            System.exit(1);
//        }
//        helper = new CLFormatter(model.getHost(), model.getPort());
//
//        if (model.printSplash = true);
//        {
//            System.out.print(helper.formatSplash(model.getUser()));
//        }
//        loop(helper, reader);
//        } catch (Exception ex) {
//        throw new RuntimeException(ex);
//        } finally {
//        reader.close();
//        if (helper.chan.isOpen()) {
//            // If the channel is open, send Bye and close
//            helper.chan.send(new Bye());
//            helper.chan.close();
//        }
//        }
    }*/


/**    
//  public void loop(CLFormatter helper, BufferedReader reader) throws IOException,
//      ClassNotFoundException {
//
//    // The app is in one of two states: "Main" or "Drafting"
//    //State state = State.MAIN;  // Initial state
//
//
//
//    // The loop
//    for (boolean done = false; !done;) {
//
//      // Print user options
//      if (controller.getModel().getState() == State.MAIN) {
//        System.out.print(helper.formatMainMenuPrompt());
//      } else {  // state = "Drafting"
//        System.out.print(helper.
//            formatDraftingMenuPrompt(controller.getModel().getDraftTopic(), controller.getModel().getDraftLines()));
//      }
//
//      // Read a line of user input
//      String raw = reader.readLine();
//      if (raw == null) {
//        throw new IOException("Input stream closed while reading.");
//      }
//      // Trim leading/trailing white space, and split words according to spaces
//      splitInput(raw);
//      String cmd = controller.getModel().getCmd();
//      String[] rawArgs = controller.getModel().getRawArgs();
////      List<String> split = Arrays.stream(raw.trim().split("\\ "))
////          .map(x -> x.trim()).collect(Collectors.toList());
////      String cmd = split.remove(0);  // First word is the command keyword
////      String[] rawArgs = split.toArray(new String[split.size()]);
//      // Remainder, if any, are arguments
//
//      // Process user input
//      if ("exit".startsWith(cmd)) {
//        // exit command applies in either state
//        done = true;
//      } // "Main" state commands
//      else if (controller.getModel().getState() == State.MAIN) {
//        if ("compose".startsWith(cmd)) {
//          // Switch to "Drafting" state and start a new "draft"
//          controller.getModel().setStateDrafting();
//          controller.getModel().setDraftTopic(rawArgs[0]);
//        } else if ("fetch".startsWith(cmd)) {
//          // Fetch seets from server
//          Command fetch = new CommandWords(controller.getModel()).getCommand(cmd);
//          fetch.execute();
//          
////          helper.chan.send(new SeetsReq(rawArgs[0]));
////          SeetsReply rep = (SeetsReply) helper.chan.receive();
////          System.out.print(
////              helper.formatFetched(rawArgs[0], rep.users, rep.lines));
//        } else {
//          System.out.println("Could not parse command/args.");
//        }
//      } // "Drafting" state commands
//      else if (controller.getModel().getState()== State.DRAFTING) {
//        if ("body".startsWith(cmd)) {
//          // Add a seet body line
//          Command body = new CommandWords(controller.getModel()).getCommand(cmd);
//          body.execute();
//          
//          String line = Arrays.stream(rawArgs).
//              collect(Collectors.joining());
//          controller.getModel().addDraftLines(line);
//        } else if ("send".startsWith(cmd)) {
//          // Send drafted seets to the server, and go back to "Main" state
//          helper.chan.send(new Publish(controller.getModel().getUser(), controller.getModel().getDraftTopic(), controller.getModel().getDraftLines()));
//          controller.getModel().setStateMain();
//          controller.getModel().setDraftTopic(null);
//        } else {
//          System.out.println("Could not parse command/args.");
//        }
//      } else {
//        System.out.println("Could not parse command/args.");
//      }
//    }
//    return;
//  }*/
//    @Override
//    public SeeterController getController(){
//        return controller;
//    }
    
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
    public void readUserInput(BufferedReader reader) throws IOException{
        //reader = new BufferedReader(new InputStreamReader(System.in));
       String raw = reader.readLine();
       // splitInput(raw);
       if(raw == null){throw new IOException("input stream closed while reading");}
      List<String> split = Arrays.stream(raw.trim().split("\\ "))
          .map(x -> x.trim()).collect(Collectors.toList());
      String cmd = split.remove(0);  // First word is the command keyword
      model.setCmd(cmd);
      String[] rawArgs = split.toArray(new String[split.size()]);
      model.setRawArgs(rawArgs);
      
    }
    //////////////////////////////////////////////////////////////////////
    public void checkClient(){
        if (model.getClient().getUser().isEmpty() || model.getClient().getHost().isEmpty()) {
            System.err.println("User/host has not been set.");
            System.exit(1);
        }
        else{
            splashScreen();
        }
    }
    public void splashScreen(){
        if(model.isPrintSplash() == true){
            System.out.println(model.getCLFormatter().formatSplash(model.getClient().getUser()));
        }

    }
    
    public void printOptions(){
        if(model.getState() == State.MAIN){
            System.out.print(model.getCLFormatter().formatMainMenuPrompt());
          } 
        else {  // state = "Drafting"
        System.out.print(model.getCLFormatter().
            formatDraftingMenuPrompt(model.getDraftTopic(), model.getDraftLines()));
        }
    }  
    public void runCommand(){
        Command command = new CommandWords(model).getCommand(model.getCmd());
        command.execute();
    }

    public void loop(CLFormatter helper, BufferedReader reader) throws IOException{
        for(boolean done = false; !done;){
            printOptions();
            readUserInput(reader);
            runCommand();
        }
        
    }
    public CLFormatter getCLFormatter(){
        return helper;
    }
     public BufferedReader getReader(){
        return reader;
    }   
    @Override
    public void update() {
        printOptions();
    }
    
//    public void splash(){
//        if(m.printSplash = true){
//            System.out.println(helper.formatSplash((controller.getModel().getUser())));
//        }
//    }
//    
//    @Override
//    public void init(){
//        view.setController();
//    }
    
    

}
