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

/*
output:
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
7 x 10 = 70
*/