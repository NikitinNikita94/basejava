package com.urise.webapp.storage;
import com.urise.webapp.model.Resume;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String,Resume> mapStorage = new LinkedHashMap<>();

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey == null;
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
        mapStorage.remove(searchKey);
    }

    @Override
    protected Object getResumeSerchKey(String uuid) {
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
