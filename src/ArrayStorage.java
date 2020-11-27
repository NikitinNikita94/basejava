import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = storage.length - 1;
    
    void clear() {
        Arrays.fill(storage, size, storage.length, null);

    }

    void save(Resume r) {
        if (size < storage.length - 1) {
            storage[size] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i])) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (uuid.equals(storage[i])) {
                Arrays.fill(storage, i, storage.length, null);
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, size,  storage.length);
    }

    int size() {
        size--;
        return size;
    }
}
