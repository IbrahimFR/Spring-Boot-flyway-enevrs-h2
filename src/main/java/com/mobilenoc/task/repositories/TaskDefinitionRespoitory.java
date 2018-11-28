package com.mobilenoc.task.repositories;

import com.mobilenoc.task.models.TaskDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;

public interface TaskDefinitionRespoitory extends CrudRepository<TaskDefinition, Long>{


}
