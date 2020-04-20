/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

/**
 * command interface that all other commands implement 
 * @author Arbaaz Zakir
 */
public interface Command {
    /**
     * all classes that implement execute execute individual commands
     * allowing for encapsulation
     */
    public void execute();
}
