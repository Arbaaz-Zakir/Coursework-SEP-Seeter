/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Arbaaz Zakir
 */
public class ClientTest {
    InputStream temp = System.in;
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        String input = "exit\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(in);
    }
    
    @After
    public void tearDown() {
         System.setIn(temp);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void startUp() throws IOException {
//         InputStream temp = System.in;
         
         String input = "exit\n";
         ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
         System.setIn(in);
         
         Client client = new Client();
         client.set("userid", "localhost", 0000);
         client.run();
         
        // System.setIn(temp);
     }
     
    @Test
    public void exitCommand() throws IOException {
        String input = "exit\n";
        boolean done = false;  
        System.out.println(done);
        Client client = new Client();
        client.set("userid", "localhost", 0000);
        client.run();
         
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(in);
        
        done = true;
        assertTrue(done);
     }
    
    @Test
    public void compose() throws IOException {
        String input = "compose x\n";
            
            
        Client client = new Client();
        client.set("userid", "localhost", 0000);
        client.run();
         
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(in);
     }
    @Test
    public void send() throws IOException {
        String input = "send x\n";
            
            
        Client client = new Client();
        client.set("userid", "localhost", 0000);
        client.run();
         
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(in);
     }
}
