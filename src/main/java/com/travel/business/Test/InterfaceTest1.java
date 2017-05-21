package com.travel.business.Test;

public interface InterfaceTest1 {
	
	void impMe(String s);
	
	default void test(){
		System.out.println("I can be here");
	} 

}
