package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList();

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return listStorage.get((Integer) searchKey);
    }

    @Override
    protected void updateResume(Resume resume,Object searchKey) {
        listStorage.set((Integer) searchKey,resume);
    }

    @Override
    protected void saveResume(Resume resume,Object searchKey) {
        listStorage.add(resume);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected List<Resume> getAll() {
        return listStorage;
    }

    @Override
    protected void deleteResume(Object searckKey) {
        listStorage.remove(((Integer) searckKey).intValue());
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}
