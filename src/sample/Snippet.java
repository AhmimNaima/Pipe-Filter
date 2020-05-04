import java.util.Scanner;

public class Snippet {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	Pipe p1 = new BlockingQueue();
	Pipe p2 = new BlockingQueue();
	Pipe p3 = new BlockingQueue();
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Entry un entier a");

		String s=sc.next();
		System.out.println("Entry un entier B");
		String s1=sc1.next();
		//int a=s+s1;
		p1.dataIN("+");
		p1.dataIN(s);
		p1.dataIN(s1);

	Filter a1 = new FilterA(null,p1);
	Filter b1 = new FilterB(p1,p2);
	Filter d1 = new FilterD(p2,null);
	 
	Thread th1 = new Thread( a1 );
	Thread th2 = new Thread( b1 );
	Thread th4 = new Thread( d1 );
	
	th1.start();
	th2.start();
	th4.start();
	
	}
}