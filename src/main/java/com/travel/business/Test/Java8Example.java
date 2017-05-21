package com.travel.business.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Java8Example {

public static void main(String[] args) {
		
	 testForEach();
		
	}



	public static void testForEach()
	{
		
		//creating sample Collection
				List<Integer> myList = new ArrayList<Integer>();
				for(int i=0; i<10; i++) myList.add(i);
				
				//traversing using Iterator
				Iterator<Integer> it = myList.iterator();
				while(it.hasNext()){
					Integer i = it.next();
					System.out.println("Iterator Value::"+i);
				}
				
				//traversing through forEach method of Iterable with anonymous class
				myList.forEach(new Consumer<Integer>() {

					public void accept(Integer t) {
						System.out.println("forEach anonymous class Value::"+t);
					}

				});
				
				//traversing with Consumer interface implementation
				MyConsumer action = new MyConsumer();
				myList.forEach(action);
				
				List<String> myList2 = new ArrayList<String>();
				for(int i=0; i<10; i++) myList2.add(i+"");
				MOC ex = new MOC();
				myList2.forEach(ex);
				
				InterfaceTest1 itest = (s) -> System.out.println(s);
				
				InterfaceTest1 itest2 = (s) ->{ 
				    StringBuilder sb = new StringBuilder("PREM APPEND ME");	
					System.out.println(sb.append(s).toString());
				};
				
				itest.test();
				itest.impMe("Yo Prem");
				itest2.impMe(" GOT MY LAMBDA ");
				
				streamExample();
	
	}
	
	
	
	
	
	static void  streamExample(){
		
		List<Integer> myList = new ArrayList<>();
		for(int i=0; i<100; i++) myList.add(i);
		
		//sequential stream
		Stream<Integer> sequentialStream = myList.stream();
		
		//parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();
		
		Stream<Integer> parallelStream2 = myList.stream();
		
		//using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 86);
		//using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel="+p));
		
		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 96);
		highNumsSeq.forEach(p -> System.out.println("High Nums sequential="+p));
		
		Stream<Integer> distinctSeq= parallelStream2.distinct();
		distinctSeq.forEach(p -> System.out.println("distinct number" + p.intValue()));

	}

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{

	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);
	}

}


class MOC implements Consumer<String>{


	StringBuffer buff = new StringBuffer();
	public void accept(String t) {
		System.out.println("VALUE NOW IS: "+ buff.append(t).toString());
		
	}
	
	
}


