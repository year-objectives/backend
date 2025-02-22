package org.yearobjectives.infrastructure.client.dynamodb.entity;

import java.util.List;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

/**
 * Dynamo objectives object
 */
@DynamoDbBean
public class DynamoObjectives {

    private static final String ID_COLUMN = "id";
    private static final String TYPE_COLUMN = "type";
    private static final String REVERSIBLE_COLUMN = "reversible";
    private static final String CELL_AMOUNT_COLUMN = "cell_amount";
    private static final String CREATED_AT_COLUMN = "created_at";
    private static final String USER_COLUMN = "user";

    private String id;
    private String type;
    private Boolean reversible;
    private Integer cellAmount;
    private Long createdAt;
    private String user;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(ID_COLUMN)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDbAttribute(TYPE_COLUMN)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @DynamoDbAttribute(REVERSIBLE_COLUMN)
    public Boolean getReversible() {
        return reversible;
    }

    public void setReversible(Boolean reversible) {
        this.reversible = reversible;
    }

    // public List<DynamoMarker> getMarkers() {
    //     return markers;
    // }

    // public void setMarkers(List<DynamoMarker> markers) {
    //     this.markers = markers;
    // }

    @DynamoDbAttribute(CELL_AMOUNT_COLUMN)
    public Integer getCellAmount() {
        return cellAmount;
    }

    public void setCellAmount(Integer cellAmount) {
        this.cellAmount = cellAmount;
    }

    @DynamoDbAttribute(CREATED_AT_COLUMN)
    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long startAt) {
        this.createdAt = startAt;
    }

    @DynamoDbAttribute(USER_COLUMN)
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
        
    // public record DynamoMarker(Boolean done, long concludedAt) {
    // }
    
}
