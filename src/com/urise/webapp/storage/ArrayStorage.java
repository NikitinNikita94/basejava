package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return Integer.valueOf(-1);
    }

    @Override
    protected void insertResume(Resume resume,int index) {
        storage[size] = resume;
    }

    @Override
    protected void fillDelete(int index) {
        storage[index] = storage[size - 1];
    }
}