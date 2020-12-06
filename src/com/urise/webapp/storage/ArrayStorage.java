package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0 , size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size < storage.length - 1) {
            if (r != storage[size]) {
                storage[size] = r;
                size++;
            }
        } else {
            System.out.println("ERROR: The storage is full. ");
        }
    }

    public void update(Resume r) {
        for (int i = 0; i < size; i++) {
            if (r.equals(storage[i])) {
                storage[i] = r;
            } else {
                System.out.println("ERROR: No such resume exists.");
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid() == uuid) {
                return storage[i];
            } else if (storage[i].getUuid() != uuid){
                System.out.println("ERROR: There is no such uuid in storage1");
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            } else {
                System.out.println("ERROR: There is no such uuid in storage2");
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}