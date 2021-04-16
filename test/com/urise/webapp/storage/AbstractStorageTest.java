package com.urise.webapp.storage;

import com.urise.webapp.ResumeTestData;
import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = ResumeTestData.fullResume(UUID_1, "fullName1");
        RESUME_2 = ResumeTestData.fullResume(UUID_2, "fullName2");
        RESUME_3 = ResumeTestData.fullResume(UUID_3, "fullName3");
        RESUME_4 = ResumeTestData.fullResume(UUID_4, "fullName4");
    }

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME_4);
        assertEquals(4, storage.size());
        assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveNoExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_2);
        assertEquals(2, storage.size());
        storage.get(UUID_2);
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_1, "Name");
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNoExist() throws Exception {
        Resume resume = new Resume(UUID_4);
        storage.update(resume);
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME_2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNoExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test
    public void getAll() throws Exception {
        List<Resume> resumes = storage.getAllSorted();
        assertEquals(3, resumes.size());
        assertEquals(Arrays.asList(RESUME_1, RESUME_2, RESUME_3), resumes);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }
}
