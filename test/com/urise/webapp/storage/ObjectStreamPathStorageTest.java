package com.urise.webapp.storage;

import com.urise.webapp.storage.serializable.ObjectStreamStorage;

public class ObjectStreamPathStorageTest extends AbstractStorageTest {
    public ObjectStreamPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getName(),new ObjectStreamStorage()));
    }
}
