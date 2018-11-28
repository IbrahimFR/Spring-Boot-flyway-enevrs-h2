package com.mobilenoc.task.models;

import com.sun.istack.internal.NotNull;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Audited
@Entity
@Table(name = "task_definition")
public class TaskDefinition {

    @Id
    @NotNull
    @SequenceGenerator(name = "taskdef_generator", sequenceName = "taskdef_sequence", allocationSize = 1)
    @GeneratedValue(generator = "taskdef_generator")
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
        return "TaskDefinition{" +
                "ID=" + ID +
                ", NAME='" + NAME + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
