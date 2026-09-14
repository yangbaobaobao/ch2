import java.util.*;
class Main {
	public static List<Person> Contenders = new ArrayList<Person>();
    public static void main(String[] args) {
        System.out.println("Gladiator Battles At Home:");
        Contenders.add(new Person("Ethan", 120, 1, 1));
        Contenders.add(new Person("Ryan", 100, 10, 15));
        Contenders.add(new Person("Jiahao", 1000, 4000, 17));
        for (Person p : Contenders){
			p.Declare();
		}
        Contenders.get(0).Fight(Contenders.get(1));
    }
}

class Person {
	public String name;
	protected int iq;
	protected double experience;
	protected double age;
    private double ageAffinity;
	Person(String name, int iq, double experience, double age){
		this.name = name;
		this.iq = iq;
		this.experience = experience;
		this.age = age;
        this.ageAffinity = (-0.02*(this.age - 20)*(this.age - 40) + 18);
	}

    public double getAgeAffinity(){
        return ageAffinity;
    }
	
	public void Declare() {
		System.out.println("My name is " + name + ", my iq is " + iq + "!");
		System.out.println("I am " + age + " years old, and have " + experience + " years of fighting experience!");
		System.out.println("");
	}
	
	public void Fight(Person enemy) {
		System.out.println(name + ": I challenge " + enemy.name + " to a battle!");
	}
}
