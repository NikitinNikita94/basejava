package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void save(Resume resume) {
        int index = resumeIndex(resume.getUuid());
        if (index < 0) {
            saveResume(resume);
        } else  {
            throw new ExistStorageException(resume.getUuid());
        }
    }

    public void delete(String uuid) {
        int index = resumeIndex(uuid);
        if (index >= 0) {
            deleteResume(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public void update(Resume resume) {
        int index = resumeIndex(resume.getUuid());
        if (index >= 0) {
            updateResume(index, resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public Resume get(String uuid) {
        int index = resumeIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
    }

    protected abstract Resume getResume(int index);

    protected abstract void updateResume(int index, Resume resume);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(int index);

    protected abstract int resumeIndex(String uuid);
}

