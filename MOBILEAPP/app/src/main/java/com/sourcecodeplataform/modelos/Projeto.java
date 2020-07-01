package com.sourcecodeplataform.modelos;
import java.io.Serializable;

public class Projeto implements Serializable {
    private int id;
    private String name;
    private String description;
    private String archiveFilename;
    private String scmType;

    public Projeto(int id) {
        this.id = id;
    }

    public Projeto(int id, String name, String desc, String filename, String scm) {
        this.id = id;
        this.name = name;
        this.description = desc;
        this.archiveFilename = filename;
        this.scmType = scm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArchiveFilename() {
        return archiveFilename;
    }

    public void setArchiveFilename(String archiveFilename) {
        this.archiveFilename = archiveFilename;
    }

    public String getScmType() {
        return scmType;
    }

    public void setScmType(String scmType) {
        this.scmType = scmType;
    }

    @Override
    public String toString() {
        return "Projeto{" + "id=" + id + ", name=" + name + ", description=" + description + ", archiveFilename=" + archiveFilename + ", scmType=" + scmType + '}';
    }
}
