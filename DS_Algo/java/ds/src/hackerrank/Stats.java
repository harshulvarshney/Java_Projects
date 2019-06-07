package hackerrank;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * hackerrank problem.
 * 
 * Given an interface: {@link StatisticsAggregator}
 * implement its methods in thread safe way s.t. the getter return correct result.
 * input: 1,IBM 22.22,ABPM 10.10, ABPM 10,IBM 20.22
 * first attr in input is number of threads for thread pool.
 * 
 * expected o/p:
 * getAveragePrice("IBM"): 21.22
 * getTickCount("IBM"): 2
 * 
 * @author harshul.varshney
 *
 */
public class Stats {
	
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

		private Map<String, Number[]> companyPriceMap2 = new HashMap<>(0);

		private Lock lock = new ReentrantLock();
		
		@Override
		public void putNewPrice(String symbol, double price) {
		// YOUR CODE HERE
			try {
				lock.lock();
				if(companyPriceMap2.containsKey(symbol)) {
					Number[] arr = companyPriceMap2.get(symbol);
					arr[0] = arr[0].doubleValue() + price;
					arr[1] = arr[1].intValue() + 1;
				}
				else {
					Number[] arr = new Number[2];
					arr[0] = price;
					arr[1] = 1;
					companyPriceMap2.put(symbol, arr);
				}
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
		// YOUR CODE HERE
			try {
				lock.lock();
				if(companyPriceMap2.containsKey(symbol)) {
					Number[] arr = companyPriceMap2.get(symbol);
					double avg = arr[0].doubleValue()/arr[1].intValue();
					return avg;
				}
				else {
					return 0;
				}
			}
			finally {
				lock.unlock();
			}
		}

		@Override
		public int getTickCount(String symbol) {
		// YOUR CODE HERE
			try {
				lock.lock();
				if(companyPriceMap2.containsKey(symbol)) {
					Number[] arr = companyPriceMap2.get(symbol);
					return arr[1].intValue();
				}
				else {
					return 0;
				}
			}
			finally {
				lock.unlock();
			}
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(String.format("%s %.4f %d", symbol,
						stats.getAveragePrice(symbol),
						stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}

}
