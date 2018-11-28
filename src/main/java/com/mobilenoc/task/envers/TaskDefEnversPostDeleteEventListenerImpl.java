package com.mobilenoc.task.envers;

import com.mobilenoc.task.models.TaskDefinition;
import com.mobilenoc.task.models.TaskDefinitionMirror;
import com.mobilenoc.task.repositories.TaskDefinitionMirrorRespoitory;
import com.mobilenoc.task.repositories.TaskDefinitionRespoitory;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.logging.Logger;

public class TaskDefEnversPostDeleteEventListenerImpl extends EnversPostDeleteEventListenerImpl {

    @Autowired
    private JdbcTemplate template;

    Logger log = Logger.getLogger(TaskDefEnversPostDeleteEventListenerImpl.class
            .getName());
    public TaskDefEnversPostDeleteEventListenerImpl(EnversService enversService) {
        super(enversService);
    }


    @Override
    public void onPostDelete(PostDeleteEvent event) {
        if (event.getEntity() instanceof TaskDefinition) {
            TaskDefinition taskDefinition = (TaskDefinition) event.getEntity();
            if(template!=null) {
                template.update(
                        "DELETE  task_definition_mirror  WHERE ID = ? ",
                        taskDefinition.getID()
                );
            }
        } else if (event.getEntity() instanceof TaskDefinitionMirror) {
            TaskDefinitionMirror taskDefinitionMirror = (TaskDefinitionMirror) event.getEntity();
            if(template!=null) {
                template.update(
                        "DELETE task_definition   WHERE ID = ? ",
                        taskDefinitionMirror.getID()
                );
            }
        }

    }
}
