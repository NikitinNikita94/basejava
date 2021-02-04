package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List list = new ArrayList<>();

    @Override
    protected Resume getResume(int index) {
        return (Resume) list.get(index);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        list.set(index, resume);
    }

    @Override
    protected int findIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        list.add(index, resume);
    }

    @Override
    protected void deleteResume(int index) {
        list.remove(index);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return (Resume[]) list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
