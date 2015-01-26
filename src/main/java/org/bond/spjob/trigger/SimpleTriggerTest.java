package org.bond.spjob.trigger;

import java.util.Date;

import org.bond.spjob.job.SimpleJob;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class SimpleTriggerTest {

	public static void main(String[] args) {
		try {
			// 创建job实例
			JobDetailImpl jobDetail = new JobDetailImpl();
			jobDetail.setName("job1");
			jobDetail.setGroup("group1");
			jobDetail.setJobClass(SimpleJob.class);

			// 定义调度规则
			SimpleTriggerImpl st = new SimpleTriggerImpl();
			st.setName("trigger1");
			st.setStartTime(new Date());
			st.setRepeatInterval(1000 * 10);
			st.setRepeatCount(5);

			// 获取调度实例
			StdSchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sc = sf.getScheduler();

			// 注册 调度
			sc.scheduleJob(jobDetail, st);
			sc.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
