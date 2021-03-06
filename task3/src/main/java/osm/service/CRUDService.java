package osm.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import osm.model.NodeDb;
import osm.repository.NodeRepository;
import osm.repository.TagRepository;

@Service
@RequiredArgsConstructor
public class CRUDService {
    private final NodeRepository nodeRepository;
    private final TagRepository tagRepository;

    public NodeDb create(NodeDb node) {
        tagRepository.saveAll(node.getTags());
        return nodeRepository.save(node);
    }

    public NodeDb read(Long id) {
        return nodeRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public NodeDb update(Long id, NodeDb node) {
        NodeDb nodeFromDb = nodeRepository.findById(id).orElseThrow(NullPointerException::new);
        node.setId(nodeFromDb.getId());
        return nodeRepository.save(node);
    }

    public void delete(long id) {
        NodeDb node = nodeRepository.findById(id).orElseThrow(NullPointerException::new);
        nodeRepository.delete(node);
    }

    public List<NodeDb> search(Double latitude, Double longitude, Double radius) {
        return nodeRepository.getNearNodes(latitude, longitude, radius);
    }
}

