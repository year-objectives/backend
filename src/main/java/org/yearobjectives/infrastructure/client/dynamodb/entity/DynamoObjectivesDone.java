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

    private String id;
    private String parentId;
    private Long startsAt;
    private Long endsAt;

    @DynamoDbPartitionKey
    @DynamoDbAttribute(ID_COLUMN)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @DynamoDbAttribute(ENDS_AT_COLUMN)
    public Long getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(Long endsAt) {
        this.endsAt = endsAt;
    }
}
