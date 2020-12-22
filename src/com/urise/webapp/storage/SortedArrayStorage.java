package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (size < STORAGE_LIMIT) {
            if (index < 0) {
                index = -(index) - 1;
                System.arraycopy(storage, index, storage, index + 1, size - index);
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: The such a " + resume + " already exists.");
            }
        } else {
            System.out.println("ERROR: The storage is full. ");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            System.arraycopy(storage, index, storage, index, size - index);
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("ERROR : There is nothing to delete in storage.");
        }
    }


    @Override
    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0 , size, searchKey);
    }
}
