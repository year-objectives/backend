package org.yearobjectives.infrastructure.client.dynamodb;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.List;
import java.util.stream.Collectors;

import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectives;

import io.quarkus.amazon.dynamodb.enhanced.runtime.NamedDynamoDbTable;

@ApplicationScoped
public class ObjectivesClient {

    @Inject
    @NamedDynamoDbTable("objectives")
    private DynamoDbTable<DynamoObjectives> objectivesTable;

    public List<DynamoObjectives> findAll() {
        return objectivesTable.scan().items().stream().collect(Collectors.toList());
    }

    public void create(DynamoObjectives objective) {
        objectivesTable.putItem(objective);
    }

    public DynamoObjectives getById(String id) {
        return objectivesTable.getItem(Key.builder().partitionValue(id).build());
    }

}
