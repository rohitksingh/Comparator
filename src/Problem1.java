import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Problem1 {

	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Problem1 p=new Problem1();
		//p.giveYourOutputPattern();
		//p.decreasingOrder();
		//p.repeated_and_decOrder();
		p.sortLength();
	}
	
	public void addAndDisplay(TreeSet<String> ts)
	{
		for(int i=0;i<10;i++)
		{
			ts.add(sc.nextLine());
		}
		System.out.println(ts);
	}
	
	public void defaultTreeSetAdd()
	{
		TreeSet<String> ts=new TreeSet<String>();
		addAndDisplay(ts);
	}
	
	public void giveYourOutputPattern()
	{
		TreeSet<String> modifiedTreeSet=new TreeSet<String>(){	
			
			@Override
			public String toString()
			{
				StringBuilder sb=new StringBuilder("ELEMENTS ->");
				for(String s:this)
				{
					sb.append(s+" ");
				}
				return new String(sb);
			}
		};
		
		addAndDisplay(modifiedTreeSet);
	}
	
	public void decreasingOrder()
	{
		TreeSet<String> ts=new TreeSet<String>(new DecreasingComparator());
		addAndDisplay(ts);
	}
	
	public void repeated_and_decOrder()
	{
		TreeSet<String> ts=new TreeSet<String>(new Dec_and_repeted_allowed());
		addAndDisplay(ts);
	}
	
	public void sortLength()
	{
		TreeSet<String> ts=new TreeSet<String>(new ModifiedComparator());
		addAndDisplay(ts);
	}
	
}

class DecreasingComparator implements Comparator<String>{
	
	@Override
	public int compare(String s1, String s2) {
		
		return s2.compareTo(s1);
		
	}
}

class Dec_and_repeted_allowed implements Comparator<String>{
	
	@Override
	public int compare(String s1,String s2)
	{
		
		if(s1.equals(s2))
			return +1;       //For adding s1 after s2 (s1 is the new element added)
		else
			return s2.compareTo(s1);
	}
}

class ModifiedComparator implements Comparator<String>{
	
	/*
	 * Sort in decreasing order of length of String
	 * If length is same then sort alphabetically
	 * eg [aaaaa, aaaa, bbbb, aaa, bb, a, a, a, a, b]
	 *    
	 */
	
	@Override
	public int compare(String s1,String s2)
	{
		int len1=s1.length();
		int len2=s2.length();
		
		
		 
		if(len1==len2)
		{
			if(s1.equals(s2))
				return +1;
			else
				return s1.compareTo(s2);
		}
		else
		return len2-len1;
		
	}
}

