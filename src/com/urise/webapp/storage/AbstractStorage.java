package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        saveResume(resume, getExistSerchKey(resume.getUuid()));
    }

    public void delete(String uuid) {
       deleteResume(getNotExistSerchKey(uuid));
    }

    public void update(Resume resume) {
        updateResume(resume, getNotExistSerchKey(resume.getUuid()));
    }

    public Resume get(String uuid) {
        return getResume(getNotExistSerchKey(uuid));
    }

    private Object getExistSerchKey(String uuid) {
        Object searchKey = getResumeSerchKey(uuid);
        if (!isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistSerchKey(String uuid) {
        Object searchKey = getResumeSerchKey(uuid);
        if (isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void saveResume(Resume resume,Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract Object getResumeSerchKey(String uuid);
}

