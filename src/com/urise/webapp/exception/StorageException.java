package com.urise.webapp.exception;

public class StorageException extends RuntimeException {
    private final String uuid;

    public StorageException(String storage_overflow, String uuid) {
        super(storage_overflow);
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }
}
