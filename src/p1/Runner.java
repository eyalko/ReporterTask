package p1;

public class Runner {

	
	public static void main(String... args) {

		
//		new Thread(new testappium()).start();
		new Thread(new testappium()).start();		


	}
	
	private static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}