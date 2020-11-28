import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;
    
    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                Arrays.fill(storage, i, storage.length, null);
            }
        }

    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
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
                storage[i] = storage[i + 1];
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, size,  size + 1);
    }

    int size() {
        int size = storage.length - 1;
        for (int i = 0; i < size; i++) {
            if (size == i + 1) {
                this.size++;
            }
        }
        return this.size;
    }
}
