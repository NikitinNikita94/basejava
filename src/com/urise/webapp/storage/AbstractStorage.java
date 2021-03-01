package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index < 0) {
            saveResume(resume);
        } else  {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public void delete(String uuid) {
        int index = getResumeIndex(uuid);
        if (index >= 0) {
            deleteResume(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void update(Resume resume) {
        int index = getResumeIndex(resume.getUuid());
        if (index >= 0) {
            updateResume(resume,index);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = getResumeIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
    }

    protected abstract Resume getResume(int index);

    protected abstract void updateResume(Resume resume,int index);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(int index);

    protected abstract int getResumeIndex(String uuid);
}

