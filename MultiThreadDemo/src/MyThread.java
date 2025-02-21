
public class MyThread implements Runnable{

	String name;
	MyThread(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0;i<10;i++) {
			
			System.out.println(name + " :: "+ i);
		}
		
	}
	
	public static void main(String[] args) {
		
		MyThread mt = new MyThread("Thread1");
		Thread t = new Thread(mt);
		t.start();
		
		
		Thread t1 = new Thread(mt);
		t1.start();
		
	}

}
