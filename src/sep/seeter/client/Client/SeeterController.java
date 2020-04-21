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
 * the controller part of the mvc architecture connects the model and view
 * @author Arbaaz Zakir
 */
public class SeeterController{
    private SeeterModel model;
    private SeeterView view;
    private SeeterController controller;
//     String name;
//     String host;
//     int port;
    /**
     * creating a new instance of a controller and assigning it a new controller
     * and model
     * @param model - model linked to the controller
     * @param view - view linked to the controller
     */
    public SeeterController(SeeterModel model, SeeterView view){
        this.model = model;
        this.view = view;
        
        view.setController(this);
    }

    
    /**
     * retrieves model connected to this controller
     * @return return model
     */
    public SeeterModel getModel(){
        return model;
    }
    /**
     * retrieves view connected to this controller  
     * @return return view
     */
    public SeeterView getView(){
        return view;
    }
    
    
    public void shutdown(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * run the program in a loop
     * @throws IOException 
     */
    public void runProgram() throws IOException{
        boolean done = false;
        model.setReader(new BufferedReader(new InputStreamReader(System.in, "UTF-8")));
        //view.getSplash();
        view.splashScreen();
        while(model.getState() != State.TERMINATED){
            view.run();
            view.loop(model.getCLFormatter(), model.getReader());
           // BufferedReader reader;
           // reader = new BufferedReader(new InputStreamReader(System.in));
          //  view.readUserInput(new BufferedReader(new InputStreamReader(System.in)));
        }
    }
      
}
