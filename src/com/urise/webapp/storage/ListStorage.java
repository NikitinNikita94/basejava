package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> listStorage = new ArrayList();

    @Override
    protected boolean isExist(Object index) {
        return (Integer)index < 0;
    }

    @Override
    protected Resume getResume(Object index) {
        return listStorage.get((Integer) index);
    }

    @Override
    protected void updateResume(Resume resume,Object index) {
        listStorage.set((Integer) index,resume);
    }

    @Override
    protected void saveResume(Resume resume,Object searchKey) {
        listStorage.add(resume);
    }

    @Override
    protected Integer getResumeSerchKey(String uuid) {
        for (int i = 0; i < listStorage.size(); i++) {
            if (listStorage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void deleteResume(Object searckKey) {
        listStorage.remove(searckKey);
    }

    @Override
    public void clear() {
        listStorage.clear();
    }

    @Override
    public Resume[] getAll() {
        return  listStorage.toArray(new Resume[listStorage.size()]);
    }

    @Override
    public int size() {
        return listStorage.size();
    }
}
