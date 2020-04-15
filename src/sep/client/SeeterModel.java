/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.client;
import java.util.LinkedList;
import java.util.List;
import static sep.client.State.*;
import sep.mvc.AbstractModel;
/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterModel extends AbstractModel{
    //enum States{MAIN, DRAFTING, TERMINATED}
    
    private String user;
    private String host;
    private int port;
    private State state = State.MAIN;
    
//    String draftTopic = null;
//    List<String> draftLines = new LinkedList<>();
    
    public void set(String user, String host, int port) {
        this.user = user;
        this.host = host;
        this.port = port;
    
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
    
    public String getState(){
        return state.toString();
    }
    
    public void setStateDrafting(){
        state = State.DRAFTING;
    }
    
    public void setStateMain(){
        state = State.MAIN;
    }
    
    public void setStateTerminated(){
        state = State.TERMINATED;
    }
}
