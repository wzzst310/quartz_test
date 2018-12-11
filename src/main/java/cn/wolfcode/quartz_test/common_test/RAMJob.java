package cn.wolfcode.quartz_test.common_test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by WangZhe on 2018年12月01日.
 */

public class RAMJob implements Job {

    private static Logger _log = LoggerFactory.getLogger(RAMJob.class);

    @Override
    public void execute(JobExecutionContext arg0) throws JobExecutionException {

        _log.info("Say hello to Quartz" + new Date());
        //System.out.println("hello,quartz");
    }

}
