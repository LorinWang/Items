package LockAndCondition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-24
 * Time: 上午12:14
 */
public class ConflictCondition
{
	private Lock lock = new ReentrantLock();
	private LinkedList linkedList = new LinkedList();

	private Condition condition4product = lock.newCondition();
	private Condition condition4consumer = lock.newCondition();

	private int num;

	public void product()
	{
		lock.lock();
		try
		{
			if (linkedList.size() >= 100)
			{
				condition4product.await();
			}
			num=(int)Math.random()*100;
			linkedList.add(num);
			System.out.println("Produce num:" + num);
			condition4consumer.signal();
		}catch (InterruptedException e)
		{
			e.printStackTrace();
		}finally
		{
			lock.unlock();
		}
	}

	public void consume()
	{
		lock.lock();
		try
		{
			if (linkedList.isEmpty())
			{
				condition4consumer.await();
			}
			System.out.println("Consume num:" + linkedList.pop());
		}catch (InterruptedException e)
		{
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}finally
		{
			lock.unlock();
		}
	}
}

