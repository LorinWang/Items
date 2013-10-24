package LockAndCondition;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-24
 * Time: 上午12:33
 */
public class ConsumerThread implements Runnable
{
	private ConflictCondition conflictCondition;

	public ConsumerThread(ConflictCondition conflictCondition)
	{
		this.conflictCondition = conflictCondition;
	}

	@Override
	public void run()
	{
		while (true)
		{
			conflictCondition.consume();
		}
	}
}
