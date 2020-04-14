/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.client;
import java.util.LinkedList;
import java.util.List;
import sep.mvc.AbstractModel;
/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterModel extends AbstractModel{
    private String user;
    private String host;
    private int port;
    private String state = "Main";
    
//    String draftTopic = null;
//    List<String> draftLines = new LinkedList<>();
    
    public void set(String user, String host, int port) {
        this.user = user;
        this.host = host;
        this.port = port;
    
    }
    public String getState(){
        return state;
    }
    
    public void setStateDrafting(){
        state = "Drafting";
    }
    
    public void setStateMain(){
        state = "Main";
    }
    
}
