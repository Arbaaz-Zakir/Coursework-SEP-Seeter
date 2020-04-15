/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.client;

/**
 *
 * @author Arbaaz Zakir
 */
public enum State {
    DRAFTING(" Drafting"), MAIN(" Main"), TERMINATED(" Terminated");
    
    private String state;
    
    private State(String state){
        this.state = state;
    }
}
