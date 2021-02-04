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

    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (size > STORAGE_LIMIT) {
            throw new StorageException("Storage overflow" , resume.getUuid());
        } else {
            saveResume(resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (index >= 0) {
            deleteResume(index);
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected Resume getResume(int index) {
        return storage[index];
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

    protected abstract int findIndex(String uuid);

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(int index);
}