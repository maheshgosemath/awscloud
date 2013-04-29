/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.harpro.awscloud;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.StopInstancesRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StopInstance {
    
    private AmazonEC2 ec2;
    
    public StopInstance(String accessKey, String secretKey)
    {
        if (ec2 == null) {
            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
            ec2 = new AmazonEC2Client(credentials);
        }
    }
    
    public void stopInstance(String instance)
    {
        String InstanceIDInJSP=instance;
        List<String> instancesToStop = new ArrayList<String>();
        instancesToStop.add(InstanceIDInJSP);
        StopInstancesRequest stoptr = new StopInstancesRequest();
        stoptr.setInstanceIds(instancesToStop);
        ec2.stopInstances(stoptr);
    }
    
}
