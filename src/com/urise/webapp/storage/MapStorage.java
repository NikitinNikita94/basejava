package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.LinkedHashMap;

public class MapStorage extends AbstractStorage {

    LinkedHashMap<String,Resume> map = new LinkedHashMap<>();

    @Override
    protected boolean checkNullPointer(Object index) {
        return index == null;
    }

    @Override
    protected Resume getResume(Object index) {
        return (Resume) index;
    }

    @Override
    protected void updateResume(Resume resume, Object index) {
        map.replace(resume.getUuid(),resume);
    }

    @Override
    protected void saveResume(Resume resume) {
        map.put(resume.getUuid(),resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected Object getResumeIndex(String uuid) {
        return map.get(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
