package com.urise.webapp.storage;

import com.urise.webapp.exceptions.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int STORAGE_LIMIT = 10000;
    protected int countResume = 0;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];


    @Override
    public final void doSave(Resume resume, Integer searchKey) {
        if (countResume >= STORAGE_LIMIT) {
            throw new StorageException("Storage is full.", resume.getUuid());
        } else {
            saveResume(resume, searchKey);
            countResume++;
        }
    }

    @Override
    public final Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    public final void doUpdate(Resume resume, Integer searchKey) {
        storage[searchKey] = resume;
    }

    @Override
    public final void doDelete(Integer searchKey) {
            deleteResume(searchKey);
            storage[countResume] = null;
            countResume--;
        }

    @Override
    public final List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOf(storage, countResume));
    }

    @Override
    protected boolean isExist(String searchKey) {
        int index = (Integer) getSearchKey(searchKey);
        if (index > -1) {
            return true;
        }
        return false;
    }

    public void clear() {
        Arrays.fill(storage, 0, countResume, null);
        countResume = 0;
    }

    public int size() {
        return countResume;
    }

    abstract void saveResume(Resume resume, int index);

    abstract void deleteResume(int index);

}
