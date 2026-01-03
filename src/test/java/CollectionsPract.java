
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class CollectionsPract {

	public static void main(String[] args) {
		// ArrayList
/*		List <Integer> list2 = new ArrayList<>(Arrays.asList(44,55,66,77));
		List <Integer> list = new ArrayList<>();
		list.add(0,9);
		list.add(1,2);
		list.add(2,55);
		list.add(3,4);
		list.add(5);
		System.out.println(list);
//		list.remove(0);
//		System.out.println("removed at index 0 " + list);
//		list.remove(Integer.valueOf(3));
//		System.out.println(list);
//		list.removeLast();
//		list.removeFirst();
//		list.removeAll(list);
//		list.removeAll(Arrays.asList(1,2));
//		list.addAll(list2);
//		list2.addAll(list);
//		System.out.println(list2);
//		list2.removeAll(list);
//		System.out.println(list2.get(2));
//		list.set(2, 99);
//		System.out.println(list.size());
//		System.out.println(list.contains(9));
//		Collections.shuffle(list);
//		Collections.sort(list);
//		list.clear();
		System.out.println(list.isEmpty());
		
		String [] arr = {"A","B"};
		ArrayList<String> list4 = new ArrayList<>(Arrays.asList(arr));
		System.out.println(list4);
		
*/
		
		//LinkedList
/*		List<Integer> lkdList = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>(Arrays.asList(10,20));
		lkdList.add(100); //[100]
		lkdList.add(1, 200); //[100,200]
		lkdList.addFirst(50); //[50,100,200]
		lkdList.addLast(250); //[50,100,200,250]
//		lkdList.addAll(Arrays.asList(260,270)); //[50, 100, 200, 250, 260, 270]
//		lkdList.addAll(2, list2); //[50, 100, 10, 20, 200, 250]
//		lkdList.remove(1); //[50, 200, 250]
//		lkdList.remove(Integer.valueOf(100)); //[50, 200, 250]
//		lkdList.removeFirst(); //[100, 200, 250]
//		lkdList.removeLast(); //[50, 100, 200]
//		lkdList.removeAll(Arrays.asList(50,200)); //[100, 250]
//		System.out.println(lkdList.contains(Integer.valueOf(100))); //true
//		lkdList.clear(); //[]
//		lkdList.set(3, 900); //[50, 100, 200, 900]
//		System.out.println(lkdList.size()); //4
		List<Integer> list3 = new LinkedList<>(Arrays.asList(90,22,80,10,20));

//		Collections.sort(list3); //[10, 20, 22, 80, 90]
//		Collections.sort(list3, Collections.reverseOrder()); //[90, 80, 22, 20, 10]
//		Collections.shuffle(list3); //[80, 10, 90, 22, 20]
//		System.out.println(list3);
//
///
 */
		//HashSet
/*		Set<Integer> hs = new HashSet<> ();
		hs.add(11);
		hs.add(11);
		hs.add(11);
		hs.add(11);
		System.out.println(hs); // [11]
		hs.remove(11);
		System.out.println(hs); //[]
		hs.add(12);
		hs.add(13);
		hs.add(14);
		hs.add(15);
		System.out.println(hs);
		boolean b = hs.contains(Integer.valueOf(14));
		System.out.println(b); //true
		int size = hs.size();
		System.out.println(size); //4
		System.out.println(hs.isEmpty());
		hs.clear();
		System.out.println(hs);
*/		
		
		//LinkedHashSet
/*		Set <Integer> hs = new HashSet<>();
		hs.add(100);
		hs.add(200);
		hs.add(300);
		hs.add(400);
		System.out.println(hs); //[400, 100, 200, 300] insertion order not preserved
		
		Set<Integer> lhs = new LinkedHashSet<>();
		lhs.add(100);
		lhs.add(200);
		lhs.add(300);
		lhs.add(400);
		System.out.println(lhs); //[100, 200, 300, 400] insertion order preserved
*/
		//PriorityQueue 
/*		Queue <Integer> pQ = new PriorityQueue<> ();
		pQ.add(122);
		pQ.offer(133);
		pQ.offer(144);
		pQ.offer(155);
//		System.out.println(pQ);
//		pQ.poll();
//		System.out.println(pQ);
//		pQ.poll();
//		System.out.println(pQ);
//		pQ.poll();
//		System.out.println(pQ);
//		pQ.remove();
//		System.out.println(pQ);
//		pQ.poll();
		System.out.println(pQ.poll()); //[] no exception, returns null even if the queue is empty
//		pQ.remove();
		System.out.println(pQ); //throws No such element exception
		
//		System.out.println(pQ.element());
//		System.out.println(pQ);
//		System.out.println(pQ.peek());
		
*/   
		//hashMap
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "Red");
		hm.put(2, "Blue");
		hm.put(3, "Yellow"); //{1=Red, 2=Blue, 3=Yellow}
//		hm.put(null, null); //{null=null, 1=Red, 2=Blue, 3=Yellow}
//		hm.put(null, "Nothing"); //{null=Nothing, 1=Red, 2=Blue, 3=Yellow}
		hm.put(4, null); //{1=Red, 2=Blue, 3=Yellow, 4=null}
//		System.out.println(hm);
//		System.out.println(hm.get(1)); //Red
//		System.out.println(hm.get(9)); //null (even if key does not exists)
		hm.remove(3);
		System.out.println(hm); //{1=Red, 2=Blue, 4=null}
		System.out.println(hm.containsKey(2)); //true
		System.out.println(hm.containsKey(9)); //false
		System.out.println(hm.containsValue("red")); //false (case sensitive)
		hm.put(5, "White");
		hm.put(6, "White");
		System.out.println(hm); //{1=Red, 2=Blue, 4=null, 5=White, 6=White}
		System.out.println(hm.size());  //5
		Map<Integer, String> hm2 = new HashMap<>();
		hm2.put(1, "Tiger");
		hm2.put(2, "Lion");
		hm2.put(3, "Cat");
		System.out.println(hm2); //{1=Tiger, 2=Lion, 3=Cat}
		hm.putAll(hm2);
		System.out.println(hm); //{1=Tiger, 2=Lion, 3=Cat, 4=null, 5=White, 6=White}
		hm2.clear();
		System.out.println(hm2); //{}
		System.out.println(hm2.isEmpty()); //true
	}

}
