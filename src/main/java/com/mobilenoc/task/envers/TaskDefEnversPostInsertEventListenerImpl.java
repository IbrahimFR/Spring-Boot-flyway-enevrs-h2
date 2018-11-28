package com.mobilenoc.task.envers;

import com.mobilenoc.task.models.TaskDefinition;
import com.mobilenoc.task.models.TaskDefinitionMirror;

import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostInsertEventListenerImpl;
import org.hibernate.event.spi.PostInsertEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.transaction.Transactional;
import java.util.logging.Logger;

public class TaskDefEnversPostInsertEventListenerImpl extends EnversPostInsertEventListenerImpl {

    @Autowired
    private JdbcTemplate template;
    Logger log = Logger.getLogger(TaskDefEnversPostInsertEventListenerImpl.class
            .getName());

    public TaskDefEnversPostInsertEventListenerImpl(EnversService enversService) {
        super(enversService);
    }

   @Transactional
    @Override
    public void onPostInsert(PostInsertEvent event) {
        if (event.getEntity() instanceof TaskDefinition) {
           TaskDefinition taskDefinition = (TaskDefinition) event.getEntity();
            if(template!=null) {
                template.update(
                        "INSERT INTO task_definition_mirror (NAME, Description) VALUES (?, ?)",
                        taskDefinition.getNAME(), taskDefinition.getDescription()
                );
            }
        } else if (event.getEntity() instanceof TaskDefinitionMirror) {
            TaskDefinitionMirror taskDefinitionMirror = (TaskDefinitionMirror) event.getEntity();
            if(template!=null) {
                template.update(
                        "INSERT INTO task_definition (NAME, Description) VALUES (?, ?)",
                        taskDefinitionMirror.getNAME(), taskDefinitionMirror.getDescription()
                );
            }
          //  taskDefinitionRespoitory.save(taskDefinition);
        }
    }

}