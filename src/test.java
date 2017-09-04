//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
*/
public class test {
    private String host = "localhost";
    private int port = 8890;
    private String accessKey = "eyJ4cC51IjoyMzc0LCJ4cC5wIjoyLCJ4cC5tIjoiTUEiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE4MTY4Njk4ODUsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.ZxoKq-TS4puDw_73gYPhF_ELyh4iyzWqVs-mB5SRKKg";
    private String projectBaseDirectory = "C:\\Users\\eyal.kopelevich\\workspace\\project5";
    protected Client client = null;
    protected GridClient grid = null;
    
    private String deviceQuery = "@os='android'";
    

    @Before
    public void setUp(){
        // In case your user is assign to a single project you can provide an empty string, 
        // otherwise please specify the project name
        grid = new GridClient(accessKey, "cloud.experitest.com",443, true);
        client = grid.lockDeviceForExecution("testLogin", deviceQuery, 10, 50000);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "testLogin");
    }

    @Test
    public void testchrome(){
        // This command "setDevice" is not applicable for GRID execution 
    	if(client.install("cloud:com.experitest.ExperiBank/.LoginActivity", true, false)){
            // If statement
        }
        client.launch("com.experitest.ExperiBank/.LoginActivity", true, false);
        client.elementSendText("NATIVE", "xpath=//*[@hint='Username']", 0, "company");
        client.elementSendText("NATIVE", "xpath=//*[@hint='Password']", 0, "company");
        client.click("NATIVE", "xpath=//*[@id='loginButton']", 0, 1);
    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future. 
        client.releaseClient();
    }
}
