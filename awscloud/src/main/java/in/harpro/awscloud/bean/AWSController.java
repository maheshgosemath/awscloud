/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package in.harpro.awscloud.bean;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.simpledb.AmazonSimpleDB;
import com.amazonaws.services.simpledb.AmazonSimpleDBClient;
import in.harpro.awscloud.CreateInstance;
import in.harpro.awscloud.StartInstance;
import in.harpro.awscloud.StopInstance;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Administrator
 */
@ManagedBean
@RequestScoped
public class AWSController {

    /**
     * Creates a new instance of AWSController
     */
    
    private AmazonEC2 ec2;
    private AmazonS3 s3;
    private AmazonSimpleDB sdb;
    
    public AWSController() {
    }
    
    public void config()
    {
        if (ec2 == null) {
            AWSCredentials credentials = new BasicAWSCredentials("AKIAJBOVVKPTQTU6NTFA","h6PxFJjo8P66P8vF2uoZmx+GgYBZZVBU8bfLAVtg");
            ec2 = new AmazonEC2Client(credentials);
            s3  = new AmazonS3Client(credentials);
            sdb = new AmazonSimpleDBClient(credentials);
        }
    }
    
    public void startInstance()
    {
        StartInstance si=new StartInstance(ec2);
        si.startInstance();
    }
    
    public void stopInstance()
    {
        StopInstance sti=new StopInstance(ec2);
        sti.stopInstance();
    }
    
    public void createInstance()
    {
        CreateInstance ci=new CreateInstance(ec2);
        ci.createInstance();
    }
    
}
