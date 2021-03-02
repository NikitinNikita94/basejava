package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.LinkedHashMap;

public class MapStorage extends AbstractStorage {

    private LinkedHashMap<String,Resume> mapStorage = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Object index) {
        return index == null;
    }

    @Override
    protected Resume getResume(Object index) {
        return (Resume) index;
    }

    @Override
    protected void updateResume(Resume resume, Object index) {
        mapStorage.replace(resume.getUuid(),resume);
    }

    @Override
    protected void saveResume(Resume resume,Object searchKey) {
        mapStorage.put(resume.getUuid(),resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        mapStorage.remove(searchKey);
    }

    @Override
    protected Object getResumeIndex(String uuid) {
        return mapStorage.get(uuid);
    }

    @Override
    public void clear() {
        mapStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return mapStorage.values().toArray(new Resume[mapStorage.size()]);
    }

    @Override
    public int size() {
        return mapStorage.size();
    }
}
