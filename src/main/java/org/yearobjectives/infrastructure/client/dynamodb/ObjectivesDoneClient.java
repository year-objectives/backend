package org.yearobjectives.infrastructure.client.dynamodb;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.List;
import java.util.stream.Collectors;

import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectives;
import org.yearobjectives.infrastructure.client.dynamodb.entity.DynamoObjectivesDone;

import io.quarkus.amazon.dynamodb.enhanced.runtime.NamedDynamoDbTable;

@ApplicationScoped
public class ObjectivesDoneClient {

    @Inject
    @NamedDynamoDbTable("objectives-done")
    private DynamoDbTable<DynamoObjectivesDone> objectivesTable;

    public List<DynamoObjectivesDone> findAll() {
        return objectivesTable.scan().items().stream().collect(Collectors.toList());
    }

    public void create(DynamoObjectivesDone objective) {
        objectivesTable.putItem(objective);
    }

    public DynamoObjectivesDone getById(String id) {
        return objectivesTable.getItem(Key.builder().partitionValue(id).build());
    }
}
