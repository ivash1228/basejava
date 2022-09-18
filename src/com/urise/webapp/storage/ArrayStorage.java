package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected int getSearchKey(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        index = size();
        storage[index] = resume;
    }

    @Override
    protected void deleteResume(int index) {
         storage[index] = storage[size()];
    }

}
