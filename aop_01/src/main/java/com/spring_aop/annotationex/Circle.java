package com.spring_aop.annotationex;

public class Circle {
	private double radius;
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
        this.radius = radius;
    }
	
	public void showResult() {
		double area = Math.PI * radius * radius;
		double perimeter = 2 * Math.PI * radius;
		
		System.out.println("반지름 " + radius + "인 원의 면적: " + area);
		System.out.println("반지름 " + radius + "인 원의 둘레: " + perimeter);
	}
	
	
}
