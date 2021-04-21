package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private List<Resume> listStorage = new ArrayList<>();

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return listStorage.get(searchKey);
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        listStorage.set(searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
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
    protected void doDelete(Integer searckKey) {
        listStorage.remove(searckKey.intValue());
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
