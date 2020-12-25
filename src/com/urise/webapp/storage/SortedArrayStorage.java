package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume(Resume resume, int index) {
        index = -(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[size] = resume;
        size++;
    }


    @Override
    protected void deleteResume(String uuid, int index) {
        System.arraycopy(storage, index, storage, index, size - index);
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }


    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0 , size, searchKey);
    }
}
