/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.client.Client;

/**
 *
 * @author Arbaaz Zakir
 */
public class ExitCommand implements Command{

    @Override
    public void execute() {
        System.exit(0);
    }
    
}
