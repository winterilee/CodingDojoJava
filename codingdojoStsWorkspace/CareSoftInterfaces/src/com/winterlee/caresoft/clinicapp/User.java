package com.winterlee.caresoft.clinicapp;

public class User {
	protected Integer id;
    protected int pin;
    
    public User(Integer id) {
    	setId(id);
    }

	public Integer getId() {
		return id;
	}
	private void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	protected void setPin(int pin) {
		this.pin = pin;
	}
    
}
