package com.student.modal;


public class Student {

	Long id;
	
	String name;
	
    Long mark;
    
    String city;
    
    Long classNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMark() {
		return mark;
	}

	public void setMark(Long mark) {
		this.mark = mark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(Long classNumber) {
		this.classNumber = classNumber;
	}
	
    public Student() {
    	
    }

	public Student(Long id, String name, Long mark, String city, Long classNumber) {
		super();
		this.id = id;
		this.name = name;
		this.mark = mark;
		this.city = city;
		this.classNumber = classNumber;
	}
    

}
