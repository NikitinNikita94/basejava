import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0 , size, null);
        size = 0;
    }

    void save(Resume r) {
        if (size < storage.length - 1) {
            storage[size] = r;
            size++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (uuid.equals(storage[i])) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length - 1; i++) {
            if (uuid.equals(storage[i])) {
                storage[i - 1] = storage[i];
                storage[i] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }
}