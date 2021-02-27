package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveResume(Resume resume) {
        int index = resumeIndex(resume.getUuid());
        index = -(index) - 1;
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        System.arraycopy(storage, index, storage, index, size - index);
        storage[index] = storage[size - 1];
    }

    @Override
    protected int resumeIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0 , size, searchKey);
    }
}
