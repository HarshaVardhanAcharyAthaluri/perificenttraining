
public class College implements Runnable{

	int seats = 1;
	
	@Override
	public void run() {
		allotSeat();
	}
	
	synchronized private void allotSeat() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Seats Befor Allocating ::" + seats);
		if(seats>0) {
			try {
				Thread.sleep(2000);
				System.out.println("Seat Allocated Succefully to :: "+ name);
				seats = seats -1;
				System.out.println("After Allotment to "+ name +" remaining :: "+ seats);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Sorry unable to allocate seat :: " + name);
		}
	}
	

}
