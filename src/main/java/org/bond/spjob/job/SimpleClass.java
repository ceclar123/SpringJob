package org.bond.spjob.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleClass {
	/**
	 * 执行定时统计任务 自行指定方法
	 */
	public void execute() {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()) + "执行ExampleJob2");

	}
}
