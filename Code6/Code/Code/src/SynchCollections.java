import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
interface A
{
	interface B{
		
	}
}
public class SynchCollections {

	public static void main(String[] args) {
		
		HashMap<String,Integer> map = new HashMap<>();
		map.put("amit", 2222);
		map.put("ram", 4222);
		map.put("shyam", 3222);
		map.put("sohan", 22222);
		Set<String> keys = map.keySet();
		Iterator<String> keyItr = keys.iterator();
		while(keyItr.hasNext()){
			String key = keyItr.next();
			System.out.println(key +" "+map.get(key));
		}
		System.out.println("************************");
		for(Map.Entry<String, Integer> m : map.entrySet()){
			System.out.println(m.getKey()+" "+m.getValue());
		}
		// TODO Auto-generated method stub
		//ConcurrentSkipListSet<E>
		//ConcurrentHashMap<K, V>
		
		CopyOnWriteArrayList<Integer> l2 = new CopyOnWriteArrayList<>();
		//ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(10);l2.add(20);l2.add(30);
		for(Integer i : l2){
			l2.add(0,1000);
		}
		System.out.println("After Loop "+l2);
		ArrayList l = new ArrayList();
		synchronized(l){
			l.add(100);
			l.remove(0);
			
		}
		l.add(888);
		List l22 = Collections.synchronizedList(l);

	}

}
