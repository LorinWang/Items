package Synchronize;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-23
 * Time: 下午11:16
 */
public class ConflictResource
{
	private LinkedList linkedList = new LinkedList();

	public synchronized void produceResource(int num) throws InterruptedException
	{
		if (linkedList.size() >= 100)
		{
			wait();
		}
		linkedList.offer(num);
		System.out.println("Produce num:" + num);
		notify();
	}

	public synchronized void consumeResource() throws InterruptedException
	{
		if (linkedList.isEmpty())
		{
			wait();
		}
		System.out.println("Comsume num:" + linkedList.pop());
		notify();
	}
}
