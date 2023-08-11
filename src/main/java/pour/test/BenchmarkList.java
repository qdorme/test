package pour.test;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@Getter
@Builder
@ToString
public class BenchmarkList {


	private Integer value;


	public static void main(String[] args) {
		Collection<BenchmarkList> arrayList = new ArrayList<>();
		Collection<BenchmarkList> linkedList = new LinkedList<>();
		BenchmarkList c = BenchmarkList.builder().value(1).build();

		Instant start = Instant.now();
		for(int i = 0; i<10_000_000; i++) arrayList.add(c);
		arrayList.forEach(myClass2 -> myClass2.getValue());
		Instant middle = Instant.now();
		for(int i = 0; i<10_000_000; i++) linkedList.add(c);
		linkedList.forEach(myClass2 -> myClass2.getValue());
		Instant finish = Instant.now();

		System.out.println(Duration.between(start,middle).toMillis());  // <400
		System.out.println(Duration.between(middle,finish).toMillis()); // > 1200

		start = Instant.now();
		for(int i = 0; i<10_000_000; i++) arrayList.add(c);
		for(BenchmarkList d : arrayList) d.getValue();
		middle = Instant.now();
		for(int i = 0; i<10_000_000; i++) linkedList.add(c);
		for(BenchmarkList d : linkedList) d.getValue();
		finish = Instant.now();

		System.out.println(Duration.between(start,middle).toMillis());  // <160
		System.out.println(Duration.between(middle,finish).toMillis()); // > 1400

		start = Instant.now();
		Iterator<BenchmarkList> iterator = arrayList.iterator();
		while(iterator.hasNext()) iterator.next();
		middle = Instant.now();
		Iterator<BenchmarkList> iterator1 = linkedList.iterator();
		while (iterator1.hasNext()) iterator1.next();
		finish = Instant.now();

		System.out.println(Duration.between(start,middle).toMillis());  // 19
		System.out.println(Duration.between(middle,finish).toMillis()); // 89

		start = Instant.now();
		arrayList.stream().forEach(BenchmarkList::getValue);
		middle = Instant.now();
		linkedList.stream().forEach(BenchmarkList::getValue);
		finish = Instant.now();

		System.out.println(Duration.between(start,middle).toMillis());  // 16
		System.out.println(Duration.between(middle,finish).toMillis()); // 70



	}
}
