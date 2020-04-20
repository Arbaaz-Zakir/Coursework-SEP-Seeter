/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

/**
 * states of the system as enums
 * @author Arbaaz Zakir
 */
public enum State {
    DRAFTING(" Drafting"), MAIN(" Main"), TERMINATED(" Terminated");

    
    private String state;
    /**
     * creates a new state variable to store one of the enums
     * @param st 
     */
    private State(String st){
        state = st;
        
    }
    /**
     * returns state as a string
     * @return String state
     */
    public String toString() {
        return state;
    }    
}
