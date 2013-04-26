/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.harpro.awscloud;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.Tag;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class CreateInstance {
    
    private AmazonEC2 ec2;
    
    public CreateInstance(AmazonEC2 ec2)
    {
        this.ec2=ec2;
    }
    
    public void createInstance()
    {
        String InstanceIDInJSP;//=request.getParameter("InstanceID");
        List<String> instancesToStart = new ArrayList<String>();
        instancesToStart.add("");

        //CREATE EC2 INSTANCES
        RunInstancesRequest runInstancesRequest = new RunInstancesRequest()
         .withInstanceType("t1.micro")
         .withImageId("ami-005daf69")
         .withMinCount(1)
         .withMaxCount(1)
         .withSecurityGroupIds("soaAppSecurity")
         .withKeyName("soakey")
        ;
        RunInstancesResult runInstances = ec2.runInstances(runInstancesRequest);

        //TAG EC2 INSTANCES
        List<Instance> instances = runInstances.getReservation().getInstances();
        int idx = 1;
        for (Instance instance : instances) {
            CreateTagsRequest createTagsRequest = new CreateTagsRequest();
            createTagsRequest.withResources(instance.getInstanceId()) //
               .withTags(new Tag("Name", "FirstSDKInstance" + idx));
            ec2.createTags(createTagsRequest);

            idx++;
        }
    }
    
}
