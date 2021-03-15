package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

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
    protected void saveResume(Resume resume,Object index) {
        if (size < STORAGE_LIMIT) {
            insertResume(resume,(Integer) index);
            size++;
        } else {
            throw new StorageException("Storage overflow" , resume.getUuid());
        }
    }

    @Override
    protected void updateResume(Resume resume,Object index) {
        storage[(Integer) index] = resume;
    }

    @Override
    protected void deleteResume(Object index) {
        fillDelete((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume getResume(Object index) {
        return storage[(Integer) index];
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    @Override
    protected List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOf(storage,size));
    }

    public int size() {
        return size;
    }

    protected abstract void fillDelete(int index);

    protected abstract void insertResume(Resume resume,int index);
}