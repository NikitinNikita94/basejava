package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        Object index = getResumeIndex(resume.getUuid());
        if (checkNullPointer(index)) {
            saveResume(resume);
        } else  {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public void delete(String uuid) {
        Object index = getResumeIndex(uuid);
        if (!checkNullPointer(index)) {
            deleteResume(uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void update(Resume resume) {
        Object index = getResumeIndex(resume.getUuid());
        if (!checkNullPointer(index)) {
            updateResume(resume,index);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        Object index = getResumeIndex(uuid);
        if (checkNullPointer(index)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
    }

    protected abstract boolean checkNullPointer(Object index);

    protected abstract Resume getResume(Object index);

    protected abstract void updateResume(Resume resume, Object index);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(String uuid);

    protected abstract Object getResumeIndex(String uuid);
}

