package com.mobilenoc.task;

import com.mobilenoc.task.models.TaskDefinition;
import com.mobilenoc.task.models.TaskDefinitionMirror;
import com.mobilenoc.task.repositories.TaskDefinitionMirrorRespoitory;
import com.mobilenoc.task.repositories.TaskDefinitionRespoitory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskApplicationTests {

	@Autowired
	private JdbcTemplate template;
	@Autowired
	private TaskDefinitionRespoitory definitionRespoitory;
	@Autowired
	private TaskDefinitionMirrorRespoitory mirrorRespoitory;

	@Test
	public void testDefaultSettings() {
		assertThat(this.template.queryForObject("SELECT COUNT(*) from task_definition", Integer.class)).isEqualTo(2);
	}
	@Test
	public void testCountAfterInsert() {

		TaskDefinition taskDefinition = new TaskDefinition();
		taskDefinition.setNAME("test task");
		definitionRespoitory.save(taskDefinition);
		assertThat(this.template.queryForObject("SELECT COUNT(*) from task_definition_mirror", Integer.class)).isEqualTo(3);
	}
	@Test
	public void testCountAfterDelete() {
		Optional<TaskDefinition> taskDefinition = definitionRespoitory.findById(1l);
		definitionRespoitory.delete(taskDefinition.get());
		assertThat(this.template.queryForObject("SELECT COUNT(*) from task_definition_mirror", Integer.class)).isEqualTo(1);
	}
	@Test
	public void testReverseCountAfterInsert() {

		TaskDefinitionMirror taskDefinition = new TaskDefinitionMirror();
		taskDefinition.setNAME("test task");
		mirrorRespoitory.save(taskDefinition);
		assertThat(this.template.queryForObject("SELECT COUNT(*) from task_definition", Integer.class)).isEqualTo(3);
	}

	@Test
	public void testReverseCountAfterDelete() {
		Optional<TaskDefinitionMirror> taskDefinition = mirrorRespoitory.findById(1l);
		mirrorRespoitory.delete(taskDefinition.get());
		assertThat(this.template.queryForObject("SELECT COUNT(*) from task_definition", Integer.class)).isEqualTo(1);
	}

	}
