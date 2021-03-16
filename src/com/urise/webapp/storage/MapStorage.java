package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    Map<String,Resume> mapResume = new LinkedHashMap<>();

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
        mapResume.replace(resume.getUuid(),resume);
    }

    @Override
    protected void saveResume(Resume resume, Object searchKey) {
        mapResume.put(resume.getUuid(),resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        mapResume.remove(((Resume) searchKey).getUuid());
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>( mapResume.values());
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
