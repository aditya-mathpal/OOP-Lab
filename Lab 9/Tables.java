class NewThread extends Thread {
	private int num;
	NewThread(int x) {
		this.num = x;
	}
	public void run() {
			for(int i=1;i<=10;i++) System.out.println(this.num + " x " + i + " = " + this.num*i);
	}
}

class Tables {
	public static void main(String args[]) {
		NewThread t1 = new NewThread(5);
		NewThread t2 = new NewThread(7);
		t1.start();
		try {
			t1.join();
		}
		catch(InterruptedException e) {}
		t2.start();
	}
}