import java.util.Scanner;

public class TestLinkedBag  {

	public static void main(String[] args) {
		LBag <String> myBag = new LBag <> ();
		Scanner input = new Scanner (System.in);
		
		// Type "Boston" at least once 
		for (int idx = 0; idx < 5; idx ++) {
			System.out.print ("Type a name: ");
			myBag.add (input.next());
		}
		
		myBag.add ("aaa");
		myBag.add ("bbb");
		myBag.add ("aaa");
		
		System.out.println ("Does the bag contain Boston? " + 
		     myBag.contains ("Boston"));
		
		Object[] names = myBag.toArray();
		
		for (Object name: names) 
			System.out.println (name);
		
		System.out.println (myBag.getCurrentSize() + " strings");
		
		System.out.println ("The string aaa appears " + myBag.getFrequencyOf ("aaa")
		                    + " times ");
		myBag.remove();
		
		System.out.println ("The string aaa appears " + myBag.getFrequencyOf ("aaa")
        + " times ");
		
		myBag.remove ("bbb");
		
		System.out.println ("The string aaa appears " + myBag.getFrequencyOf ("aaa")
        + " times ");
		
		System.out.println ("The string bbb appears " + myBag.getFrequencyOf ("bbb")
        + " times ");
		
		myBag.clear();
		System.out.println ("Is the bag empty ? " + myBag.isEmpty());
		myBag.add ("Wentworth");
		
		names = myBag.toArray();
		
		for (Object name: names) 
			System.out.println (name);
		System.out.println ("Is the bag empty ? " + myBag.isEmpty());
	}

}