package com.mobilenoc.task;

import com.mobilenoc.task.models.TaskDefinition;
import com.mobilenoc.task.repositories.TaskDefinitionMirrorRespoitory;
import com.mobilenoc.task.repositories.TaskDefinitionRespoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootApplication
public class TaskApplication {
    @Autowired
	TaskDefinitionRespoitory taskDefinitionRespoitory;


	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(TaskDefinitionMirrorRespoitory repository) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				TaskDefinition taskDefinition = new TaskDefinition();
				taskDefinition.setDescription("ffff");
				taskDefinition.setNAME("ggggg");
			//	taskDefinitionRespoitory.save(taskDefinition);
			//	List<TaskDefinition> ff = (List<TaskDefinition>) repository.findAll();
				System.err.println(repository.findAll());
			}

		};
	}
}
