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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@ManagedBean
@SessionScoped
public class AWSController {

    /**
     * Creates a new instance of AWSController
     */
    @NotNull (message = "Please enter AccessKey")
    @Size(min=4, max=30, message = "Please enter valid AccessKey")
    private String accessKey;
    @NotNull (message = "Please enter SecretKey")
    @Size(min=4, max=50, message = "Please enter valid SecretKey")
    private String secretKey;
    private List domainName;
    private List buckets;
    private List instanceNames;
    
    private AmazonEC2 ec2;
    private AmazonS3 s3;
    private AmazonSimpleDB sdb;
    
    private String instance;
    /**
     *
     * @param accessKey
     * @param secretKey
     */
    public AWSController(String accessKey, String secretKey) {
        this.accessKey=accessKey;
        this.secretKey=secretKey;
    }
 
    public AWSController()
    {
        
    }
    
    /**
     *
     * @return
     */
    public String config()
    {
        if (ec2 == null) {
            AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
            ec2 = new AmazonEC2Client(credentials);
            s3  = new AmazonS3Client(credentials);
            sdb = new AmazonSimpleDBClient(credentials);
            domainName=sdb.listDomains().getDomainNames();
            buckets=s3.listBuckets();
            /*for (Reservation reservation : ec2.describeInstances().getReservations()) {
                for (Instance instances : reservation.getInstances()) {
                    System.out.println(instances.getInstanceId());
                    System.out.println(instances.getArchitecture());
                    System.out.println(instances.getState());
                    System.out.println(instances.getInstanceType());
                }
            }*/
            
            return "success";
        }
        return "failure";
    }
 
    public void startInstance()
    {
        StartInstance si=new StartInstance(accessKey, secretKey);
        si.startInstance(instance);
    }
  
    public void stopInstance()
    {
        StopInstance sti=new StopInstance(accessKey, secretKey);
        sti.stopInstance(instance);
    }
  
    public void createInstance()
    {
        CreateInstance ci=new CreateInstance(accessKey, secretKey);
        ci.createInstance(instance);
    }
    
    /**
     *
     * @return
     */
    public String getAccessKey()
    {
        return accessKey;
    }
    
    /**
     *
     * @param accessKey
     */
    public void setAccessKey(String accessKey)
    {
        this.accessKey=accessKey;
    }
    
    /**
     *
     * @return
     */
    public String getSecretKey()
    {
        return secretKey;
    }
    
    /**
     *
     * @param secretKey
     */
    public void setSecretKey(String secretKey)
    {
        this.secretKey=secretKey;
    }
    
    /**
     *
     * @return
     */
    public List getDomainNames()
    {
        return domainName;
    }
    
    /**
     *
     * @return
     */
    public List getBuckets()
    {
        return buckets;
    }
    
    /**
     *
     * @return
     */
    public List getInstanceNames()
    {
        return instanceNames;
    }
    
    /**
     *
     * @param instance
     */
    public void setInstance(String instance)
    {
        this.instance=instance;
    }
    
    /**
     *
     * @return
     */
    public String getInstance()
    {
        return instance;
    }
    
}
