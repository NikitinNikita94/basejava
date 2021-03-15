package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        Object searchKey =  getNotExistedSearchKey(resume.getUuid());
        saveResume(resume,searchKey);
    }

    public void delete(String uuid) {
        Object searchKey =  getExistedSearchKey(uuid);
        deleteResume(searchKey);
    }

    public void update(Resume resume) {
        Object searchKey =  getExistedSearchKey(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey =  getExistedSearchKey(uuid);
        return getResume(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = getAll();
        Collections.sort(list);
        return list;
    }

    private Object getNotExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getExistedSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(Object searchKey);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract void saveResume(Resume resume,Object searchKey);

    protected abstract void deleteResume(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract List<Resume> getAll();
}

