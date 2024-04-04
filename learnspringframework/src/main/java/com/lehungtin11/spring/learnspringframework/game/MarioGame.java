package com.lehungtin11.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component
public class MarioGame implements GamingConsole {
	public void left() {
		System.out.println("left");
	}
	
	public void right() {
		System.out.println("right");
	}
	
	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("down");
	}
}
