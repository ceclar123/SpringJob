package org.bond.spjob.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

	@Override
	public void execute(JobExecutionContext jobCtx)
			throws JobExecutionException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(jobCtx.getTrigger().getClass().getName()
				+ ":time is:" + format.format(new Date()));

	}

}
