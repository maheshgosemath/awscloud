/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.harpro.awscloud;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StopInstance {
    
    private AmazonEC2 ec2;
    
    public StopInstance(AmazonEC2 ec2)
    {
        this.ec2=ec2;
    }
    
    public void stopInstance()
    {
        String InstanceIDInJSP;//=request.getParameter("InstanceID");
        List<String> instancesToStop = new ArrayList<String>();
        instancesToStop.add("");
        StopInstancesRequest stoptr = new StopInstancesRequest();
        stoptr.setInstanceIds(instancesToStop);
        ec2.stopInstances(stoptr);
    }
    
}
