package com.tpg.mspoc.scheduler;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class.getSimpleName());
    private static final Logger audit = LoggerFactory.getLogger("daily.scheduledTasks");
	

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public static final JobDetail job =  new JobDetail(); 
    
    @Value("${spring.profiles.active}")
    private String profile=null;
    
    @Scheduled(fixedRate = 300000)
    public void executeTask() {
    	try {
    		log.info("Current Thread : {}", Thread.currentThread().getName());
			log.info("APPLICATION PROFILE: {}",profile);
			
			String timeStamp = dateFormat.format(new Date());
			
			log.info(">>>>>>>> The executeTask STARTED <<<<<<<<<<<<< at {}", timeStamp);
			job.setJobId(job.getJobId()+1);
			job.setTimestamp(timeStamp);
			audit.info("Job Id:{}    Timestamp:{}", 
					ScheduledTasks.job.getJobId(),
					ScheduledTasks.job.timestamp);
			log.info("!!!!!!!!! The executeTask FINISHED !!!!!!!!!!");
		} catch (Exception e) {
			
			e.printStackTrace();
			log.error("************** Job Interrupted************ : {}",e.getClass());
			log.error("************** Job Interrupted-Message ************** : {}",e.getLocalizedMessage());
		}
    }
}