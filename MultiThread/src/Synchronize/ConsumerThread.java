package Synchronize;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-23
 * Time: 下午11:22
 */
public class ConsumerThread extends Thread
{
	private ConflictResource conflictResource = null;

	public ConsumerThread(ConflictResource conflictResource)
	{
		this.conflictResource = conflictResource;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				this.conflictResource.consumeResource();
			}catch (InterruptedException e)
			{
				e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
			}
		}
	}
}
