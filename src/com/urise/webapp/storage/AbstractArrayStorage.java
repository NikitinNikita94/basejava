package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void saveResume(Resume resume) {
        if (size < STORAGE_LIMIT) {
            storage[size] = resume;
            size++;
        } else {
            throw new StorageException("Storage overflow" , resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }
    @Override
    protected Resume getResume(int index) {
        return storage[index];
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage[index] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}