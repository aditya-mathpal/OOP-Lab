class Counter {
	static int count = 0;
	Counter() {
		count++;
	}
	static void showCount() {
		System.out.println("The number of Counter objects created is "+count);
	}
}

class CounterDemo {
	public static void main(String args[]) {
		Counter a = new Counter();
        Counter b = new Counter();
        Counter c = new Counter();
        Counter.showCount();
        Counter d = new Counter();
        Counter.showCount();
	}
}

/*
The number of Counter objects created is 3
The number of Counter objects created is 4
*/