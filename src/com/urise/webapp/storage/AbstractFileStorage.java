package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    public AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory must be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not Read/Write");
        }
        this.directory = directory;
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected Resume getResume(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(),e);
        }
    }

    @Override
    protected void updateResume(Resume resume, File file) {
        if (file != null) {
            try {
                doWrite(resume, file);
            } catch (IOException e) {
                throw new StorageException("IO error", file.getName(),e);
            }
        }
    }

    @Override
    protected void saveResume(Resume resume, File file) {
        try {
            file.createNewFile();
            doWrite(resume, file);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(),e);
        }
    }

    @Override
    protected void deleteResume(File file) {
        if(file != null) {
            file.delete();
        } else {
            throw new StorageException("Error", file.getName());
        }
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected List<Resume> getAll() {
        File[] file  = directory.listFiles();
        List<Resume> listFile = new ArrayList<>(file.length);
        return  listFile;
    }

    @Override
    public void clear() {
        String[] file = directory.list();
        for (String list : file) {
            deleteResume(new File(list));
        }
    }

    @Override
    public int size() {
        String[] file = directory.list();
        return file.length;
    }

    protected abstract void doWrite(Resume resume, File file) throws IOException;
    protected abstract Resume doRead(File file) throws IOException;
}
