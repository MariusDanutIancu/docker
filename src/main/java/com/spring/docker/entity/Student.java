package com.spring.docker.entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;

    /**
     * 
     */
    public Student() {
		super();
	}

    /**
     * 
     * @param id
     * @param name
     * @param email
     */
	public Student(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
        this.email = email;
    }
        
    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}