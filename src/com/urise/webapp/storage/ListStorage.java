package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;


public class ListStorage extends AbstractStorage<Integer> {

    protected final List<Resume> storage = new ArrayList<>();

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
        storage.add(resume);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        int index = (Integer) searchKey;
        return storage.get(index);
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        storage.set(storage.indexOf(resume), resume);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        int index = searchKey;
        storage.remove(index);
    }

    @Override
    public List<Resume> doCopyAll() {
        return List.copyOf(storage);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isExist(String uuid) {
        return storage.contains(new Resume(uuid));
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        return storage.indexOf(new Resume(uuid));
    }
}
