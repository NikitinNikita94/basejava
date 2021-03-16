package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorageUuid extends AbstractStorage {

    private Map<String,Resume> mapStorage = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void updateResume(Resume resume, Object searchKey) {
        mapStorage.replace(resume.getUuid(),resume);
    }

    @Override
    protected void saveResume(Resume resume,Object searchKey) {
        mapStorage.put(resume.getUuid(),resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        mapStorage.remove(((Resume) searchKey).getUuid());
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>( mapStorage.values());
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}
