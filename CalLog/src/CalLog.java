import java.io.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Lorin
 * Date: 13-10-25
 * Time: 下午12:05
 */
public class CalLog
{
	public static void main(String[] args) throws IOException
	{
		String fileName="d:/a.log";
		File file=new File(fileName);
		BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
		String str;
		String[] strArray;
		int value;
		HashMap<String,Integer> hashMap=new HashMap<String,Integer>();
		while ((str=bufferedReader.readLine())!=null)
		{
			strArray=str.split(" ");
			if (strArray[0].equals("beijing"))
			{
				if(hashMap.get(strArray[1])!=null)
				{
					value=hashMap.get(strArray[1]);
					hashMap.put(strArray[1], value + 1);
				}
				else
				{
					hashMap.put(strArray[1],1);
				}
			}
        }

		/*Iterator iterator=hashMap.entrySet().iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}*/

		ArrayList arrayList=new ArrayList(hashMap.entrySet());
		Collections.sort(arrayList,new Comparator<Map.Entry<String, Integer>>()
		{
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
			{
				return (o2.getValue()-o1.getValue());
			}
		});

		Iterator iterator=arrayList.iterator();
		while(iterator.hasNext())
		{
			Map.Entry entry= (Map.Entry) iterator.next();
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}

	}

}