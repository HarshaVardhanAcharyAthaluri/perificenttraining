
public class Allotment {

	public static void main(String[] args) {
		
		College c1= new College();

		Thread t = new Thread(c1);
		t.setName("VIVEK");
		t.start();
		

		Thread t1 = new Thread(c1);
		t1.setName("ANAND");
		t1.start();
		
	}
}
