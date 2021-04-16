package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void save(Resume resume) {
        LOG.info(" Save " + resume);
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        saveResume(resume, searchKey);
    }

    public void delete(String uuid) {
        LOG.info(" Delete " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        deleteResume(searchKey);
    }

    public void update(Resume resume) {
        LOG.info(" Update " + resume);
        SK searchKey = getExistedSearchKey(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public Resume get(String uuid) {
        LOG.info(" Get " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        return getResume(searchKey);
    }

    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted");
        List<Resume> list = getAll();
        Collections.sort(list);
        return list;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Get " + uuid + " not exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(SK searchKey);

    protected abstract Resume getResume(SK searchKey);

    protected abstract void updateResume(Resume resume, SK searchKey);

    protected abstract void saveResume(Resume resume, SK searchKey);

    protected abstract void deleteResume(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract List<Resume> getAll();
}

