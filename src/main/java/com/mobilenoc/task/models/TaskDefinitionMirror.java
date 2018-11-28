package com.mobilenoc.task.models;

import com.sun.istack.internal.NotNull;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Table(name = "task_definition_mirror")
@Audited
public class TaskDefinitionMirror{

    @Id
    @NotNull
    @SequenceGenerator(name = "taskdefmirror_generator", sequenceName = "taskdefmirror_sequence", allocationSize = 1)
    @GeneratedValue(generator = "taskdefmirror_generator")
    private Long ID;

    @NotNull
    private String NAME;

    private String Description;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "TaskDefinitionMirror{" +
                ", NAME='" + NAME + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
