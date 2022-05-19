package org.sebi.incident;

import java.util.Date;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Incident extends PanacheEntity {

    public String description;
    public Date date;
    public boolean status;

    public String getDescription() {
        return description;
    }

    public Incident setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Incident setDate(Date date) {
        this.date = date;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public Incident setStatus(boolean status) {
        this.status = status;
        return this;
    }
}
