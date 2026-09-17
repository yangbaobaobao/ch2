import java.util.*;
import java.lang.Thread;
class Main {
	public static Scanner sc;
	public static List<Person> Contenders = new ArrayList<Person>();
	public static Person character;
	public static void DeleteLine() {
		System.out.print("\r\033[2k");
        System.out.flush();
    }
    public static void main(String[] args) {
		sc = new Scanner(System.in);
        System.out.println("Gladiator Battles At Home:");
        Contenders.add(new Person("Ethan", 125, 10, 10));
        Contenders.add(new Person("Ryan", 100, 10, 15));
        Contenders.add(new Person("Jiahao", 1000, 4000, 17));
        for (Person p : Contenders){
			p.Declare();
			p.AddAttack(new Attack("punch", p, 1.0, 0, 30));
			p.AddAttack(new Attack("kick", p, 0.5, 0, 50));
			p.AddAttack(new Attack("slap", p, 0.9, 0.5, 15));
			if (p.name.equals("Ethan")) {
				p.AddAttack(new Attack("kiss", p, 0.4, 1, 5));
			}
		}
        //Contenders.get(0).Fight(Contenders.get(1));
        boolean proceed = false;
        String s;
        while(!proceed){
			System.out.println("Select your gladiator: ");
			s = sc.nextLine();
			for (Person p : Contenders){
				if (p.name.toLowerCase().equals(s.toLowerCase())){
					character = p;
					proceed = true;
					System.out.println(p.name + ": Yay! Im selected!");
				}
			}
		} 
		Ask();
    }
    
    public static void Fight(Person enemy) {
		System.out.print("Choose Action: ");
		for (Attack att : character.attacks){
			System.out.print(att.name + " ");
		}
		System.out.println("");
		String s = sc.nextLine();
		s = s.toLowerCase();
		for (Attack att : character.attacks){
			if (s.equals(att.name.toLowerCase())){
				att.Hit(enemy);
				Fight(enemy);
			}
		}
		System.out.println("ATTACK NOT FOUND");
		Fight(enemy);
	}
    
    public static void Ask() {
		System.out.print("Choose Action: ");
		System.out.print("inspect ");
		System.out.print("fight ");
		System.out.print("train ");
		System.out.print("cheer ");
		System.out.println("");
		String s = sc.nextLine();
		s = s.toLowerCase();
		if (s.equals("inspect")) {
			character.Declare();
			Ask();
		}
		else if (s.split(" ")[0].equals("fight")) {
			if (s.split(" ").length == 1){
				System.out.println("INCORRECT SYNTAX: fight [name of enemy]");
				Ask();
			}
			for (Person p : Contenders){
				if (p.name.toLowerCase().equals(s.split(" ")[1])){
					if (p.name.equals(character.name)) {
						System.out.println("YOU CANT ATTACK YOURSELF");
						Ask();
					}
					else {
						character.Fight(p);
						Fight(p);
					}
				}
			}
			System.out.println("INCORRECT SYNTAX: fight [name of enemy]");
			Ask();
		}
		else{Ask();}
	}
}

class Attack {
	public String name;
	public int damage;
	public double hitRate;
	public double reloadRate;
	
	public Person parent;
	
	Attack(String name, Person parent, double hitRate, double reloadRate, int damage) {
		this.name = name;
		this.damage = damage;
		this.hitRate = hitRate;
		this.reloadRate = reloadRate;
		this.parent = parent;
	}
	
	public static void DeleteLine() {
		System.out.print("\r\033[2k");
        System.out.flush();
    }
	
	public boolean Hit(Person enemy){
		boolean[] bar = new boolean[10];
		int barPos = 0;
		bar[barPos] = true;
		boolean gaba = true;
		int timer = 0;
		System.out.print("☑");
		while (gaba) {
			timer++;
			try {
				DeleteLine();
				for (boolean b : bar) {
					if (b){
						System.out.print("[X]");}
					else{
						System.out.print("[ ]");}
				}
				barPos = (int)(5*Math.sin(timer) + 5);
				System.out.print(barPos);
				//barPos++;
				for (int i = 0; i < bar.length; i++) {
					bar[i] = false;}
				bar[barPos] = true;
				if (barPos >= 10) {barPos = 0;}
				Thread.sleep(100);
			}
			catch (Exception e){}
		}
		if (Math.random() > hitRate){
			System.out.println(parent.name + " tried to " + name + " " + enemy.name + ", but missed...");
			return false;
		}
		else{
			System.out.println(parent.name + " " + name + "ed " + enemy.name + "!");
			if (Math.random() < reloadRate){
				System.out.println(enemy.name + " is stunned!, attack again!");
			}
			return true;
		}
	}
}

class Person {
	public String name;
	protected int iq;
	protected double experience;
	protected double age;
    private double ageAffinity;
    
    public List<Attack> attacks = new ArrayList<Attack>();
    
	Person(String name, int iq, double experience, double age){
		this.name = name;
		this.iq = iq;
		this.experience = experience;
		this.age = age;
        this.ageAffinity = (-0.02*(this.age - 20)*(this.age - 40) + 18);
	}
	
	public void AddAttack(Attack attack){
		attacks.add(attack);
	}

    public double GetAgeAffinity(){
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
