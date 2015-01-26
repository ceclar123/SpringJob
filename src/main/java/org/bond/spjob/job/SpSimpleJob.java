package org.bond.spjob.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class SpSimpleJob extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext jobContext)
			throws JobExecutionException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(jobContext.getTrigger().getClass().getName()
				+ ":time is:" + format.format(new Date()));
	}

	private int timeout;

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
