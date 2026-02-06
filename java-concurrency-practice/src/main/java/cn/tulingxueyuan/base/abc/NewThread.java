package cn.tulingxueyuan.base.abc;

import cn.tulingxueyuan.tools.SleepTools;

import java.util.concurrent.*;

/**
 *类说明：新启线程的方式
 */
public class NewThread {
	/*扩展自Thread类*/
	private static class UseThread extends Thread{
		@Override
		public void run() {
			super.run();
			SleepTools.second(1);
			// do my work;
			System.out.println("I am extendec Thread");
		}
	}

	
	/*实现Runnable接口*/
	private static class UseRunnable implements Runnable{

		@Override
		public void run() {
			// do my work;
			System.out.println("I am implements Runnable");

		}
	}



	private static class UseCallable implements Callable<String> {
		@Override
		public String call() throws Exception {
			System.out.println("I am implements Callable");
			return "I am callable";
		}
	}

	private static class UseFuture implements Future<String>{

		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			return false;
		}

		@Override
		public boolean isCancelled() {
			return false;
		}

		@Override
		public boolean isDone() {
			return false;
		}

		@Override
		public String get() throws InterruptedException, ExecutionException {
			System.out.println("I am implements Future");
			return "future executed";
		}

		@Override
		public String get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
			return "";
		}
	}



	

	public static void main(String[] args)
            throws Exception {
		UseThread useThread = new UseThread();
		useThread.start();
		//useThread.start();

		UseRunnable useRunnable = new UseRunnable();
		new Thread(useRunnable).start();
		System.out.println("main end");

		UseCallable useCallable = new UseCallable();
		System.out.println(useCallable.call());


		UseFuture useFuture = new UseFuture();
		System.out.println(useFuture.get());


	}
}
