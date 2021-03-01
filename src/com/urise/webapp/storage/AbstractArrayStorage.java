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
        int index = getResumeIndex(resume.getUuid());
        if (size < STORAGE_LIMIT) {
            insertResume(resume,index);
            size++;
        } else {
            throw new StorageException("Storage overflow" , resume.getUuid());
        }
    }

    @Override
    protected void deleteResume(int index) {
        fillDelete(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume getResume(int index) {
        return storage[index];
    }

    @Override
    protected void updateResume(Resume resume,int index) {
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

    protected abstract void fillDelete(int index);

    protected abstract void insertResume(Resume resume,int index);
}