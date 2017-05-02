package org.ywb.study.entity;

import java.io.Serializable;

/**
 * User: yangwenbiao@passiontec.cn
 * Date: 2017/3/17
 * Time: 13:41
 */
public class City implements Serializable {

    private static final long serialVersionUID = 4493596793851424771L;
    private long id;
    private String name;
    private String description;

    public City() {
        super();
    }

    public City(long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
