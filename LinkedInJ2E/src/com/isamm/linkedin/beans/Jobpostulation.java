package com.isamm.linkedin.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Jobpostulation {
    private int id;
    private int idjob;
    private int iduser;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idjob", nullable = false)
    public int getIdjob() {
        return idjob;
    }

    public void setIdjob(int idjob) {
        this.idjob = idjob;
    }

    @Basic
    @Column(name = "iduser", nullable = false)
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jobpostulation that = (Jobpostulation) o;
        return id == that.id &&
                idjob == that.idjob &&
                iduser == that.iduser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idjob, iduser);
    }
}
