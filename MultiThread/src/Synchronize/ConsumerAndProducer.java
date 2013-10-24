package Synchronize;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-23
 * Time: 下午11:10
 */
public class ConsumerAndProducer
{
	private static ConflictResource conflictResource=new ConflictResource();

	public static void main(String[] args)
	{
		ConsumerThread consumerThread=new ConsumerThread(conflictResource);
		ProducerThread producerThread=new ProducerThread(conflictResource);

		consumerThread.start();
		producerThread.start();

	}
}
