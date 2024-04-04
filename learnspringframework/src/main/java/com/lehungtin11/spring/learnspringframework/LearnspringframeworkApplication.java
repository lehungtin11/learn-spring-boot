package com.lehungtin11.spring.learnspringframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.lehungtin11.spring.learnspringframework.enterprise.example.web.MyWebController;
import com.lehungtin11.spring.learnspringframework.game.GameRunner;

@SpringBootApplication
public class LearnspringframeworkApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LearnspringframeworkApplication.class, args);
		
		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();
		
		 MyWebController controller = context.getBean(MyWebController.class);
		 
		 System.out.println(controller.returnValueFromBusinessService());
		
//		MarioGame game = new MarioGame();
//		GameRunner runner = new GameRunner (game);
//		runner.run();
	}

}
