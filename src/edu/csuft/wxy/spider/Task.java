package edu.csuft.wxy.spider;

/**
 * 定义一个可以交给线程去执行的任务
 * @author 19812
 *
 */

public class Task implements Runnable{

	//任务的编号
	int n;
	
	public Task(int n) {
		super();
		this.n = n;
	}

	@Override
	public void run() {
		//得到线程的名字
		String name = Thread.currentThread().getName();
		System.out.println(name + "开始 : " + n);
		//延时
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + "结束 : " + n);
	}

}
