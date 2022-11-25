package com.urise.webapp.storage;

import com.urise.webapp.exceptions.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected int countResume = 0;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];


    @Override
    public final void doSave(Resume resume, Object searchKey) {
        if (countResume >= STORAGE_LIMIT) {
            throw new StorageException("Storage is full.", resume.getUuid());
        } else {
            int index = (Integer) searchKey;
            saveResume(resume, index);
            countResume++;
        }
    }

    @Override
    public final Resume doGet(Object searchKey) {
        int index = (Integer) searchKey;
        return storage[index];
    }

    @Override
    public final void doUpdate(Resume resume, Object searchKey) {
        int index = (Integer) searchKey;
        storage[index] = resume;
    }

    @Override
    public final void doDelete(Object searchKey) {
            int index = (Integer) searchKey;
            deleteResume(index);
            storage[countResume] = null;
            countResume--;
        }

    @Override
    protected boolean isExist(String uuid) {
        int index = (Integer) getSearchKey(uuid);
        if (index > -1) {
            return true;
        }
        return false;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResume);
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
