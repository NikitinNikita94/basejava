package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<Resume> {

    private Map<String,Resume> mapResume = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getResume(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void updateResume(Resume resume, Resume searchKey) {
        mapResume.replace(resume.getUuid(),resume);
    }

    @Override
    protected void saveResume(Resume resume, Resume searchKey) {
        mapResume.put(resume.getUuid(),resume);
    }

    @Override
    protected void deleteResume(Resume searchKey) {
        mapResume.remove((searchKey).getUuid());
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
