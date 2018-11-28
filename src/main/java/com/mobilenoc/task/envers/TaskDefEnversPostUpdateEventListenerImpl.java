package com.mobilenoc.task.envers;

import com.mobilenoc.task.models.TaskDefinition;
import com.mobilenoc.task.models.TaskDefinitionMirror;
import com.mobilenoc.task.repositories.TaskDefinitionMirrorRespoitory;
import com.mobilenoc.task.repositories.TaskDefinitionRespoitory;
import org.hibernate.envers.boot.internal.EnversService;
import org.hibernate.envers.event.spi.EnversPostDeleteEventListenerImpl;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostUpdateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.logging.Logger;

public class TaskDefEnversPostUpdateEventListenerImpl extends EnversPostUpdateEventListenerImpl {

    @Autowired
    private JdbcTemplate template;

    @Autowired
    TaskDefinitionRespoitory taskDefinitionRespoitory;
    Logger log = Logger.getLogger(TaskDefEnversPostUpdateEventListenerImpl.class
            .getName());
    public TaskDefEnversPostUpdateEventListenerImpl(EnversService enversService) {
        super(enversService);
    }


    @Override
    public void onPostUpdate(PostUpdateEvent event) {
        if (event.getEntity() instanceof TaskDefinition) {
            TaskDefinition taskDefinition = (TaskDefinition) event.getEntity();
            if(template!=null) {
                template.update(
                        "UPDATE  task_definition_mirror SET NAME = ? , Description = ?  WHERE ID = ? ",
                        taskDefinition.getNAME(), taskDefinition.getDescription(),taskDefinition.getID()
                );
            }
        } else if (event.getEntity() instanceof TaskDefinitionMirror) {
            TaskDefinitionMirror taskDefinitionMirror = (TaskDefinitionMirror) event.getEntity();
            if(template!=null) {
                template.update(
                        "UPDATE task_definition_mirror SET NAME = ? , Description = ?  WHERE ID = ? ",
                        taskDefinitionMirror.getNAME(), taskDefinitionMirror.getDescription(),taskDefinitionMirror.getID()
                );
            }
        }


//       super.onPostInsert(event);
    }
}
