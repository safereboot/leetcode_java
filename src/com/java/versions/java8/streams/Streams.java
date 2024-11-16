package com.java.versions.java8.streams;

import java.util.*;
import java.util.stream.Collectors;

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class Streams {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));

		Map<Integer, Product> productMap = new HashMap<>();
		productMap.put(1, new Product(1, "HP Laptop", 25000f));
		productMap.put(2, new Product(2, "Dell Laptop", 29000f));
		productMap.put(3, new Product(3, "Sony Laptop", 35000f));

//		for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
//			Integer age = entry.getKey();
//			Product p = entry.getValue();
//			System.out.println("age : " + age + " Price: " + p.price);
//		}

		//Iterate over maps
		productMap.forEach((age, p) -> System.out.println("age : " + age + " Price: " + p.price));
		
		// Without Stream
		List<Float> productPriceList = new ArrayList<Float>();
		for (Product product : productsList) {

			// filtering data of list
			if (product.price < 30000) {
				productPriceList.add(product.price); // adding price to a productPriceList
			}
		}
		System.out.println(productPriceList); // displaying data

		// With Stream
		List<Float> productPriceList2 = productsList.stream().filter(p -> p.price > 30000)// filtering data
				.map(p -> p.price) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList2);

		System.out.println("Filtered by price");
		productsList.stream().filter(p -> p.price > 25000f).collect(Collectors.toList())
				.forEach(s -> System.out.println(s.price));

		// forEach
		Random random = new Random();
		random.ints().limit(10).forEach(System.out::println);

		// map
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// get list of unique squares
		List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		// Sum of all the elements
		Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);

		// filter
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// get count of empty string
		long count = strings.stream().filter(string -> string.isEmpty()).count();

		// limit
		Random random2 = new Random();
		random2.ints().limit(10).forEach(System.out::println);

		// sorted
		Random random3 = new Random();
		random3.ints().limit(10).sorted().forEach(System.out::println);

		// parallelprocessing
		List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		// get count of empty string
		long count2 = strings2.parallelStream().filter(string -> string.isEmpty()).count();

		// collectors
		List<String> strings3 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filtered = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
	}

}
