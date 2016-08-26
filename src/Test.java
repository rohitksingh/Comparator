import java.util.Scanner;
import java.util.TreeSet;

class Student implements Comparable{

	String name;
	String dep;
	
	public Student(){}
	
	public Student(String name,String dep)
	{
		this.name=name;
		this.dep=dep;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}
	
	@Override
	public int compareTo(Object obj1)
	{
		Student s1=(Student)obj1;
		Student s2=Student.this;  //Or this same thing 
		
		String dep1=s1.getDep();
		String dep2=s2.getDep();
		
		if(dep1.equalsIgnoreCase(dep2))
		{
			String name1=s1.getName();
			String name2=s2.getName();
			if(name2.equals(name1))
				return +1;
			else
			return name2.compareTo(name1);
		}
		else{
			return dep2.compareTo(dep1);
		}
		
	}
	
	public String toString()
	{
		return dep+" "+name;
	}
	
}


public class Test{
	
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args)
	{
		TreeSet<Student> ts=new TreeSet<Student>();
		for(int i=0;i<5;i++)
		{
			Student s=new Student();
			System.out.println("Name");
			s.setName(sc.nextLine());
			System.out.println("Dep");
			s.setDep(sc.nextLine());
			ts.add(s);
		}
		System.out.println("Sorted Detaiks");
		for(Student s:ts)
			System.out.println(s);
	}
}

