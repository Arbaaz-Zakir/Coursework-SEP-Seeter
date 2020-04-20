/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import sep.mvc.AbstractController;

/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterController{
    private SeeterModel model;
    private SeeterView view;
    private SeeterController controller;
//     String name;
//     String host;
//     int port;
    
    public SeeterController(SeeterModel model, SeeterView view){
        this.model = model;
        this.view = view;
        
        view.setController(this);
    }
    public void setAll(){
        
    }
//    public void setDetails(String name, String host, int port){
//        this.name = model.getUser();
//        this.host = model.getHost();
//        this.port = model.getPort();
//        this.model.set(name, host, port);
//    }
    
  
    public SeeterModel getModel(){
        return model;
    }
  
    public SeeterView getView(){
        return view;
    }
    
  
    public void shutdown(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void runProgram() throws IOException{
        boolean done = false;
        model.setReader(new BufferedReader(new InputStreamReader(System.in)));
        //view.getSplash();
        view.splashScreen();
        while(done == false){
            view.run();
            view.loop(model.getCLFormatter(), model.getReader());
           // BufferedReader reader;
           // reader = new BufferedReader(new InputStreamReader(System.in));
          //  view.readUserInput(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
      
}
