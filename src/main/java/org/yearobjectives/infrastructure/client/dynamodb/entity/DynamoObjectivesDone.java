package org.yearobjectives.infrastructure.client.dynamodb.entity;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * Dynamo objectives object
 */
@DynamoDbBean
public class DynamoObjectivesDone {

    private static final String ID_COLUMN = "id";
    private static final String PARENT_ID_COLUMN  = "parent_id";
    private static final String STARTS_AT_COLUMN = "starts_at";
    private static final String ENDS_AT_COLUMN = "ends_at";
    private static final String OBJECTIVE_MARKER_COLUMN = "markers";

    private String id;
    private String parentId;
    private Long startsAt;
    // private List<DynamoMarker> markers;
    private Long endsAt;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(ID_COLUMN)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbPartitionKey
    @DynamoDbAttribute(PARENT_ID_COLUMN)
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String type) {
        this.parentId = type;
    }

    @DynamoDbAttribute(STARTS_AT_COLUMN)
    public Long getstartsAt() {
        return startsAt;
    }

    public void setstartsAt(Long startsAt) {
        this.startsAt = startsAt;
    }

    // public List<DynamoMarker> getMarkers() {
    //     return markers;
    // }

    // public void setMarkers(List<DynamoMarker> markers) {
    //     this.markers = markers;
    // }

    @DynamoDbAttribute(ENDS_AT_COLUMN)
    public Long getEndsAt() {
        return endsAt;
    }

    public void setCellAmount(Long endsAt) {
        this.endsAt = endsAt;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((parentId == null) ? 0 : parentId.hashCode());
        result = prime * result + ((startsAt == null) ? 0 : startsAt.hashCode());
        result = prime * result + ((endsAt == null) ? 0 : endsAt.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DynamoObjectivesDone other = (DynamoObjectivesDone) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (parentId == null) {
            if (other.parentId != null)
                return false;
        } else if (!parentId.equals(other.parentId))
            return false;
        if (startsAt == null) {
            if (other.startsAt != null)
                return false;
        } else if (!startsAt.equals(other.startsAt))
            return false;
        if (endsAt == null) {
            if (other.endsAt != null)
                return false;
        } else if (!endsAt.equals(other.endsAt))
            return false;
        return true;
    }

    
}
