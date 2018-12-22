package eg.edu.alexu.csd.oop.game.cs15.game.object;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadingPool {
	private  int nThreads;
	private PoolThread[] threads;
	private  LinkedBlockingQueue queue;
	public ThreadingPool(int nThreads) {
		this.nThreads=nThreads;
		queue= new LinkedBlockingQueue<>();
		threads=new PoolThread[nThreads];
		for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolThread();
            threads[i].start();
        }
	}
  public void execute(Runnable task)
  {
	  synchronized (queue) {
		  queue.add(task);
		  queue.notify();
	  }
  }
  private class PoolThread extends Thread {
      @Override
	public void run() {
          Runnable task;

          while (true) {
              synchronized (queue) {
                  while (queue.isEmpty()) {
                      try {
                          queue.wait();
                      } catch (InterruptedException e) {
                          System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                      }
                  }
                  task = (Runnable) queue.poll();
              }
              try {
                  task.run();
              } catch (RuntimeException e) {
                  System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
              }
          }
      }
  }
}
