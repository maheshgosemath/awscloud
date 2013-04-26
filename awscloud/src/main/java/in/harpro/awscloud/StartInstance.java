/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.harpro.awscloud;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StartInstance {
    
    private AmazonEC2 ec2;
    
    public StartInstance(AmazonEC2 ec2)
    {
        this.ec2=ec2;
    }
    
    public void startInstance()
    {
        String InstanceIDInJSP;//=request.getParameter("InstanceID");
        List<String> instancesToStart = new ArrayList<String>();
        instancesToStart.add("");
        StartInstancesRequest stoptr = new StartInstancesRequest();
        stoptr.setInstanceIds(instancesToStart);
        ec2.startInstances(stoptr);
    }
    
}
