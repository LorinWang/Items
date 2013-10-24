package Synchronize;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-23
 * Time: 下午11:22
 */
public class ProducerThread extends Thread
{
	private ConflictResource conflictResource = null;
	private int num = 0;

	public ProducerThread(ConflictResource conflictResource)
	{
		this.conflictResource = conflictResource;
	}

	@Override
	public void run()
	{
		while (true)
		{
			num = (int) (100 * Math.random());

			try
			{
				this.conflictResource.produceResource(num);
			}catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
