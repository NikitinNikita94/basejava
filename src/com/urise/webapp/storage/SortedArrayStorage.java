package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());

    @Override
    protected void insertResume(Resume resume,int index) {
        index = -(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, (size - index));
        storage[index] = resume;
    }

    @Override
    protected void fillDelete(int index) {
        System.arraycopy(storage, index, storage, index, size - index);
        storage[index] = storage[size - 1];
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid,"Name");
        return Arrays.binarySearch(storage, 0 , size, searchKey,RESUME_COMPARATOR);
    }
}
