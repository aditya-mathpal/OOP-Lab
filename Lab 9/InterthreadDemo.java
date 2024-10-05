class Q {
	int n;
	boolean state = false;

	synchronized int get() {
		while(!state)
			try {
				wait();
			}
			catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}

		System.out.println("Got: " + n);
		state = false;
		notify();
		return n;
	}

	synchronized void put(int n) {
		while(state)
			try {
				wait();
			}
			catch(InterruptedException e) {
				System.out.println("InterruptedException caught");
			}

		this.n = n;
        state = true;
        System.out.println("Put: " + n);
        notify();
	}
}

class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this,"Producer").start();
    }
    public void run() {
        int i = 0;
        while(true) q.put(i++);
    }
}

class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q = q;
        new Thread(this,"Consumer").start();
    }
    public void run() {
        while(true) q.get();
    }
}

class InterthreadDemo {
	public static void main(String args[]) {
		Q q = new Q();
		new Producer(q);
		new Consumer(q);
		System.out.println("Hit Ctrl + C to terminate");
	}
}

/*
output:
Hit Ctrl + C to terminate
Put: 0
Got: 0
Put: 1
Got: 1
Put: 2
Got: 2
*/