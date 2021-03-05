package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        saveResume(resume, getExistSearchKey(resume.getUuid()));
    }

    public void delete(String uuid) {
       deleteResume(getNoExistSearchKey(uuid));
    }

    public void update(Resume resume) {
        updateResume(resume, getNotExistSearchKey(resume.getUuid()));
    }

    public Resume get(String uuid) {
        return getResume(getNotExistSearchKey(uuid));
    }

    private Object getNoExistSearchKey(String uuid) {
        Object searchKey = getResumeSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getNotExistSearchKey(String uuid) {
        Object searchKey = getResumeSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getExistSearchKey(String uuid) {
        Object searchKey = getResumeSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void saveResume(Resume resume,Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract Object getResumeSearchKey(String uuid);
}

