package osm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import osm.model.NodeDb;

@Repository
public interface NodeRepository extends JpaRepository<NodeDb, Long> {
    @Query(value = "SELECT * FROM node_db " +
            "WHERE earth_distance(ll_to_earth(?1, ?2), ll_to_earth(node_db.latitude, node_db.longitude)) < ?3",
            nativeQuery = true)
    List<NodeDb> getNearNodes(double latitude, double longtitude, double radius);

}
