package osm.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "node_db")
public class NodeDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @Column(name = "username")
    private String name;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @OneToMany(mappedBy = "node")
    private List<TagDb> tags;

    @Override
    public String toString() {
        return "NodeDb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", tags=" + tags +
                '}';
    }
}


