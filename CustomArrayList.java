public class CustomArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    // Новый элемент
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Изменение существующего элемента
    public void set(int index, T element) {
        checkIndex(index);
        elements[index] = element;
    }

    // Получение элемента по индексу
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Удаление элемента
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    // Размер списка
    public int size() {
        return size;
    }

    // Проверка на вместимость
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }

    // Проверка на возможность использования данного значения индекса
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
