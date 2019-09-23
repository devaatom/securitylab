import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
class Subject{
	private String name;
	private int temp;
	private int clearance;
	public Subject(String subName,int clearance)
	{
		this.name = subName;
		this.temp = 0;
		this.clearance = clearance;
	}
	public int getClearanceLevel(){
	return clearance;
	}
	public int getTemp(){
	return temp;
	}
	public String getName(){
	return name;
	}
	public int read(int v)
	{
		temp = v;
		return temp;
	}
	public void printValues(){
	System.out.println(name + " "+ temp+" "+clearance);
	}
}
class Object{
	private String name;
	private int value;
	private int sensitivity;
	public Object(String name,int sensitivity)
	{
		this.name = name;
		this.value = 0;
		this.sensitivity = sensitivity;
	}
	public int getSensitivity()
	{
		return sensitivity;
	}
	public int getValue()
	{
		return value;
	}
	public int setValue(int v)
	{
		value = v;
		return value;
	}
	public String getName(){
	return name;
	}
	public void printValues(){
	System.out.println(name+" "+value+" "+sensitivity);
	}
}
public class belllapadula{
	public static int HIGH = 1;
	public static int LOW = 0;
	static HashMap subjects = new HashMap<String,Subject>();
	static HashMap objects = new HashMap<String,Object>();
	public static void main(String args[])
	{
		addSubject("lyle",LOW);
		addSubject("hal",HIGH);
		addObject("lobj",LOW);
		addObject("hobj",HIGH);
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int c = sc.nextInt();
			String sub = sc.next();
			String obj = sc.next();
			switch(c){
			case 0:
			{
				Subject s = (Subject) subjects.get(sub);
				Object o = (Object)objects.get(obj);
				System.out.println(s.getName()+" reads "+o.getName());
				int sens = o.getSensitivity();
				int clear = s.getClearanceLevel();
				int dom = dominates(clear,sens);
				if(dom>=0)
				{
					s.read(o.getValue());
				}
				else
					s.read(0);
			}
			break;
			case 1:
			{
				int v = sc.nextInt();
				Subject s = (Subject)subjects.get(sub);
				Object o = (Object)objects.get(obj);
				System.out.println(s.getName()+" writes value "+v+" "+o.getName());
				int sens = o.getSensitivity();
				int clear = s.getClearanceLevel();
				int dom = dominates(clear,sens);
				if(dom<=0)
					o.setValue(v);
			}
			
			}
			for(String n :(Set<String>)objects.keySet())
			{
				Object o = (Object) objects.get(n);
				System.out.println(o.getName()+" "+o.getValue());
			}
			for(String n :(Set<String>)subjects.keySet())
			{
				Subject o = (Subject) subjects.get(n);
				System.out.println(o.getName()+" "+o.getTemp());
			}
			}
			}
			public static void addSubject(String name,int clearance)
			{
				Subject s = new Subject(name,clearance);
				subjects.put(name,s);
			}
			public static void addObject(String name,int sensitivity)
			{
				Object s = new Object(name,sensitivity);
				objects.put(name,s);
			}
			public static int dominates(int c,int s){
			if(c<s)
				return -1;
			else if(c==s)
				return 0;
			else 
				return 1;
			}
		}
	
