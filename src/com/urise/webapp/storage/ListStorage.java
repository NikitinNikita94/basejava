package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private List<Resume> list = new ArrayList();

    @Override
    protected Resume getResume(int index) {
        return  list.get(index);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        list.set(index, resume);
    }

    @Override
    protected void saveResume(Resume resume) {
        list.add(resume);
    }

    @Override
    protected int resumeIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(uuid)) {
                return i;
            }
        }
        return -1;
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
        return  list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
