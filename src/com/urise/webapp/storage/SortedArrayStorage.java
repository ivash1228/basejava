package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size(), searchKey);
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        int insertionIndex = Math.abs(index);
        System.arraycopy(storage, insertionIndex - 1, storage, insertionIndex, size() - insertionIndex + 1);
        storage[insertionIndex - 1] = resume;
    }

    @Override
    protected void deleteResume(int index) {
        System.arraycopy(storage, index + 1,
                storage, index, size() - index - 1);
    }
}
