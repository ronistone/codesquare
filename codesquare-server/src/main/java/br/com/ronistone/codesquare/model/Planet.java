package br.com.ronistone.codesquare.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Planet {

    @Id
    @Column( name = "ID")
    @GeneratedValue
    private Long id;

    @Column( name = "NAME", nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean hasRings;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "DISCOVERY_DATE" )
    private Date discoveryDate;

    @Column( name = "ORBIT_VELOCITY" )
    private Long orbitVelocity;

    @Column( name = "CREATED_BY")
    private String createdBy;

    @Column( name = "CREATED_AT")
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    private Date createdAt;

    @Column( name = "UPDATED_BY")
    private String updatedBy;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "UPDATED_AT")
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("hasRings")
    public Boolean getHasRings() {
        return hasRings;
    }

    public void setHasRings(Boolean hasRings) {
        this.hasRings = hasRings;
    }

    public Date getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(Date discoveryDate) {
        this.discoveryDate = discoveryDate;
    }

    public Long getOrbitVelocity() {
        return orbitVelocity;
    }

    public void setOrbitVelocity(Long orbitVelocity) {
        this.orbitVelocity = orbitVelocity;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasRings=" + hasRings +
                ", discoveryDate=" + discoveryDate +
                ", orbitVelocity=" + orbitVelocity +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
