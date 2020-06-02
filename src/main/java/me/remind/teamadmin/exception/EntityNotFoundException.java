package me.remind.teamadmin.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class entityType, Long entityId) {
        super(String.format("Entity %s with id %s not found", entityType.getName(), entityId));
    }

}
