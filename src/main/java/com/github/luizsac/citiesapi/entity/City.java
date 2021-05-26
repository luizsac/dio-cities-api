package com.github.luizsac.citiesapi.entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
@TypeDefs(value = {
        @TypeDef(name = "point", typeClass = PointType.class)
})
public class City {

    public City(final Long id, final String name, final State uf, final Integer ibge,
                final Point geolocation) {
        this.id = id;
        this.name = name;
        this.uf = uf;
        this.ibge = ibge;
        this.geolocation = geolocation;
    }

    public City() {

    }

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name = "uf", referencedColumnName = "id")
    private State uf;

    private Integer ibge;

    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point geolocation;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public State getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public Point getGeolocation() {
        return geolocation;
    }

}