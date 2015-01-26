package org.bond.spjob.trigger;

import org.bond.spjob.job.SimpleJob;
import org.quartz.CronExpression;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

public class CronTriggerTest {

	public static void main(String[] args) {
		try {
			// 创建job实例
			JobDetailImpl jobDetail = new JobDetailImpl();
			jobDetail.setName("job1");
			jobDetail.setGroup("group1");
			jobDetail.setJobClass(SimpleJob.class);

			// 定义调度规则
			CronTriggerImpl ct = new CronTriggerImpl();
			ct.setName("trigger1");
			CronExpression exp = new CronExpression("0/10 * * * * ?");
			ct.setCronExpression(exp);

			// 获取调度实例
			StdSchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sc = sf.getScheduler();

			// 注册 调度
			sc.scheduleJob(jobDetail, ct);
			sc.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
