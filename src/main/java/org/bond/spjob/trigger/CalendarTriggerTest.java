package org.bond.spjob.trigger;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bond.spjob.job.SimpleJob;
import org.quartz.Scheduler;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class CalendarTriggerTest {

	public static void main(String[] args) {
		try {
			// 创建job实例
			JobDetailImpl jobDetail = new JobDetailImpl();
			jobDetail.setName("job1");
			jobDetail.setGroup("group1");
			jobDetail.setJobClass(SimpleJob.class);

			// 定义日历
			AnnualCalendar holidays = new AnnualCalendar();

			// 劳动节
			Calendar laborDay = new GregorianCalendar();
			laborDay.add(Calendar.MONTH, 5);
			laborDay.add(Calendar.DATE, 1);
			// 国庆节
			Calendar nationalDay = new GregorianCalendar();
			nationalDay.add(Calendar.MONTH, 10);
			nationalDay.add(Calendar.DATE, 1);

			ArrayList<Calendar> list = new ArrayList<Calendar>();
			list.add(laborDay);
			list.add(nationalDay);

			holidays.setDaysExcluded(list);

			// 定义调度规则
			SimpleTriggerImpl st = new SimpleTriggerImpl();
			st.setName("trigger1");
			st.setStartTime(new Date());
			st.setRepeatInterval(1000 * 5);
			st.setRepeatCount(5);
			st.setCalendarName("holidays");

			// 获取调度实例
			StdSchedulerFactory sf = new StdSchedulerFactory();
			Scheduler sc = sf.getScheduler();
			sc.addCalendar("holidays", holidays, false, false);

			// 注册 调度
			sc.scheduleJob(jobDetail, st);
			sc.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
