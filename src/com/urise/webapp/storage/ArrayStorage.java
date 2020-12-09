package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;
    int numIndex;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if (size < storage.length - 1) {
            if (!resume.equals(storage[size])) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("ERROR: The such a " + resume + "already exists.");
            }
        } else {
            System.out.println("ERROR: The storage is full. ");
        }
    }

    public void update(Resume resume) {
        numIndex = check(resume.getUuid());
        if (numIndex >= 0) {
            storage[numIndex] = resume;
        } else {
            System.out.println("ERROR: No such " + resume + " exists.");
        }
    }

    public Resume get(String uuid) {
        numIndex = check(uuid);
        if (numIndex >= 0) {
            return storage[numIndex];
        } else {
            System.out.println("ERROR: There is no such " + uuid + " in storage.");
        }
        return null;
    }

    public void delete(String uuid) {
        numIndex = check(uuid);
        if (numIndex >= 0) {
            storage[numIndex] = storage[size - 1];
            storage[size - 1] = null;
            size--;
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

    public int check(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}