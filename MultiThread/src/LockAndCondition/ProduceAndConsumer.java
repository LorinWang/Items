package LockAndCondition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-24
 * Time: 上午12:34
 */
public class ProduceAndConsumer
{
	public static void main(String[] args)
	{
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		ConflictCondition conflictCondition=new ConflictCondition();
		executorService.execute(new ProduceThread(conflictCondition));
		executorService.execute(new ConsumerThread(conflictCondition));
		executorService.shutdown();
	}
}
