/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.harpro.awscloud;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StartInstance {
    
    private AmazonEC2 ec2;
    
    public StartInstance(String accessKey, String secretKey)
    {
        if (ec2 == null) {
            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
            ec2 = new AmazonEC2Client(credentials);
        }
    }
    
    public void startInstance(String instance)
    {
        String InstanceIDInJSP=instance;
        List<String> instancesToStart = new ArrayList<String>();
        instancesToStart.add(InstanceIDInJSP);
        StartInstancesRequest stoptr = new StartInstancesRequest();
        stoptr.setInstanceIds(instancesToStart);
        ec2.startInstances(stoptr);
    }
    
}
