package acceptance.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sep.seeter.client.Client.Client;
import sep.seeter.client.Client.SeeterController;
import sep.seeter.client.Client.SeeterModel;
import sep.seeter.client.Client.SeeterView;

/**
 *
 * @author Arbaaz Zakir
 */
public class ClientTest {
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void getClientFromModel() throws IOException{  
        Client client = new Client();
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        Client test = model.getClient();

        assertEquals(client, test);
   
    }
    @Test
    public void getUserFromClient(){
        Client client = new Client();
        String user = "userid";
        client.set("userid", "localhost", 8888);
        
        assertEquals(user, client.getUser());
    }
    @Test
    public void getPortFromClient(){
        Client client = new Client();
        int port = 8888;
        client.set("userid", "localhost", 8888);
        
        assertEquals(port, client.getPort());
    }
    @Test
    public void getHostFromClient(){
        Client client = new Client();
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        
        assertEquals(host, client.getHost());
    }
}
