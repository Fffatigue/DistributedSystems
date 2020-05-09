package osm.model;

import java.util.Map;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NodeDTO {
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Double longitude;

    @NotNull
    private Double latitude;

    @NotNull
    private Map<String, String> tags;
}
