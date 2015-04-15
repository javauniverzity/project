public class Locks {

	static StringBuilder sb = new StringBuilder();

	private static Object lock = new Object();

	public synchronized static void zapisDoSB() {

		for (int i = 0; i < 1000000; i++) {

			sb.append(i + "\n");

		}

	}

	public static void vypisSB() {
		System.out.println(sb);
	}

	public static void main(String[] args) {
		{
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Locks.zapisDoSB();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
		{
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Locks.zapisDoSB();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
		{
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Locks.zapisDoSB();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
		{
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Locks.zapisDoSB();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
		{
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Locks.zapisDoSB();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
		{
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Locks.zapisDoSB();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
		{
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Locks.zapisDoSB();
				}
			};
			Thread t = new Thread(r);
			t.start();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vypisSB();

	}

}
