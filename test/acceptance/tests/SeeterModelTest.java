package acceptance.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sep.seeter.client.Client.Client;
import sep.seeter.client.Client.SeeterModel;
import sep.seeter.client.Client.State;

/**
 *
 * @author Arbaaz Zakir
 */
public class SeeterModelTest {
    
    public SeeterModelTest() {
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
    public void getClientFromModel(){
        Client client = new Client();
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        
        assertEquals(client, model.getClient());
    }
    @Test
    public void setStateDraftingInModel(){
        Client client = new Client();
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        model.setStateDrafting();
        assertEquals(State.DRAFTING, model.getState());
    }
    @Test
    public void setStateMainInModel(){
        Client client = new Client();
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        model.setStateMain();
        assertEquals(State.MAIN, model.getState());
    }
    @Test
    public void setStateTerminatedInModel(){
        Client client = new Client();
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        model.setStateTerminated();
        assertEquals(State.TERMINATED, model.getState());
    }
    @Test
    public void addLinesInModel(){
        Client client = new Client();
        String ans = "xyz";
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        model.addDraftLines("xyz");
        assertEquals(ans, model.getDraftLines().get(0));
    }
    
    @Test
    public void getDraftTopicInModel(){
        Client client = new Client();
        String ans = "yyy";
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        model.setDraftTopic("yyy");
        assertEquals(ans, model.getDraftTopic());
    } 
    @Test
    public void getCMDInModel(){
        Client client = new Client();
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        model.setCmd("exit");
        assertEquals("exit", model.getCmd());
    } 
    @Test
    public void getRawArgsInModel(){
        Client client = new Client();
        String host = "localhost";
        client.set("userid", "localhost", 8888);
        SeeterModel model = new SeeterModel(client);
        String[] x = {"exit","cmd"};
        model.setRawArgs(x);
        assertEquals(x[0], model.getRawArgs()[0]);
    } 
    
}
