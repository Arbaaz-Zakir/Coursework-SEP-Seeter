/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

import sep.mvc.AbstractController;

/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterController extends AbstractController{
    private SeeterModel model;
    private SeeterView view;
//     String name;
//     String host;
//     int port;
    
    public SeeterController(SeeterModel model, SeeterView view){
        super(model, view);
        
        //view.setController(this);
    }
    public void setAll(){
        
    }
//    public void setDetails(String name, String host, int port){
//        this.name = model.getUser();
//        this.host = model.getHost();
//        this.port = model.getPort();
//        this.model.set(name, host, port);
//    }
    
    @Override
    public SeeterModel getModel(){
        return model;
    }
    @Override
    public SeeterView getView(){
        return view;
    }
    
    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
