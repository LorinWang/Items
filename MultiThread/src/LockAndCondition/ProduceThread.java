package LockAndCondition;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-24
 * Time: 上午12:30
 */
public class ProduceThread implements Runnable
{
	private ConflictCondition conflictCondition;
	private int num;

	public ProduceThread(ConflictCondition conflictCondition)
	{
		this.conflictCondition = conflictCondition;
	}

	@Override
	public void run()
	{
		while (true)
		{

			conflictCondition.product();
		}
	}
}
