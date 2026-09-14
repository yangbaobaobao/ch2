import java.util.*;
class Main {
	public static List<Person> Contenders = new ArrayList<Person>();
    public static void main(String[] args) {
        System.out.println("Gladiator Battles At Home:");
        Contenders.add(new Person("Ethan", 120, 60, 1));
        Contenders.add(new Person("Ryan", 100, 40, 15));
        Contenders.add(new Person("Jiahao", 1000, 4000, 17));
        for (Person p : Contenders){
			p.Declare();
		}
    }
}

class Person {
	protected String name;
	protected int iq;
	protected double experience;
	protected double age;
	Person(String name, int iq, double experience, double age){
		this.name = name;
		this.iq = iq;
		this.experience = experience;
		this.age = age;
	}
	
	public void Declare() {
		System.out.println("My name is " + name + ", my iq is " + iq + "!");
		System.out.println("I am " + age + " years old, and have " + experience + " years of fighting experience!");
		System.out.println("");
	}
	
	public void Fight(Person enemy)
}
