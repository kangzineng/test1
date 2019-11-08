package com.gec.connection.bean;

public class Person {
	String name;
	int age;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean equals(Object obj){
		Person p=(Person) obj;
		return this.name.equals(p.name)&&this.age==p.age;
		
	}
	
	public String toString(){
		return this.name+"..."+this.age;
	}
	
	
}
