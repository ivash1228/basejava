package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    protected final ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public void save(Resume resume) {
        storage.add(resume);
    }

    @Override
    public Resume get(String uuid) {
        int index = storage.indexOf(new Resume(uuid));
        return storage.get(index);
    }

    @Override
    public void update(Resume resume) {
        storage.set(storage.indexOf(resume), resume);
    }

    @Override
    public void delete(String uuid) {
        storage.remove(new Resume(uuid));
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

}
