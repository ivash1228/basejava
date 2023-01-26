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
        return storage.get(searchKey.intValue());
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        storage.set(searchKey.intValue(), resume);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        storage.remove(searchKey.intValue());
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage);
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
    protected boolean isExist(Integer searchKey) {
        return searchKey != NON_EXISTING_KEY;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        return storage.indexOf(new Resume(uuid, "name"));
    }
}
