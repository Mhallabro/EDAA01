package map;

public class SimpleHashMap<K, V> implements Map<K, V> {

	private Entry<K, V>[] table;
	private int size;
	private double maxLoadFactor = 0.75;

	/**
	 * Constructs an empty hashmap with the default initial capacity (16) and
	 * the default load factor (0.75).
	 */
	public SimpleHashMap() {
		this.table = (Entry<K, V>[]) new Entry[16];
	}

	/**
	 * Constructs an empty hashmap with the specified initial capacity and the
	 * default load factor (0.75).
	 */
	public SimpleHashMap(int capacity) {
		this.table = (Entry<K, V>[]) new Entry[capacity];
	}

	@Override
	public V get(Object arg0) {
		K key = (K) arg0;
		Entry<K, V> result = find(index(key), key);
		if (result == null)
			return null;
		return result.getValue();
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		int index = index(key);
		Entry<K, V> entry = (Entry<K, V>) table[index];
		V result = null;

		if (entry == null) {
			table[index] = new Entry<K, V>(key, value);
		} else {
			while (true) {
				if (entry.getKey().equals(key)){
					result = entry.setValue(value);
					break;
				}
				if (entry.next == null) {
					entry.next = new Entry<K, V>(key, value);
					break;
				}
				entry = entry.next;
			}
		}
		if (result == null) size++;
		if (overLoadFactor()){
			resize(2*table.length);
		}
		return result;
	}

	private void resize(int newSize) {
		Entry<K, V>[] oldTable = table;
		table =(Entry<K, V>[]) new Entry[newSize];
		size = 0;
		for (Entry<K,V> entry : oldTable){
			while (entry != null){
				put(entry.key, entry.value);
				entry = entry.next;
			}
		}
	}

	private boolean overLoadFactor() {
		return (size()/(double)table.length) > maxLoadFactor ;
	}

	@Override
	public V remove(Object arg0) {
		K key = (K) arg0;
		int index = index(key);
		V result = null;
		Entry<K, V> entry = (Entry<K, V>) table[index];
		if (entry == null)
			result = null;
		else if (entry.getKey().equals(key)) {
			result = entry.value;
			table[index] = entry.next;
		} else {
			while (entry.next != null) {
				if (entry.next.getKey().equals(key)) {
					result = entry.next.value;
					entry.next = entry.next.next;
					break;
				}
				entry = entry.next;
			}
		}
		if (result != null)
			size--;
		return result;
	}

	@Override
	public int size() {
		return size;
	}

	public class Entry<K, V> implements Map.Entry<K, V> {

		private V value;
		private K key;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}

		@Override
		public K getKey() {
			return this.key;
		}

		@Override
		public V getValue() {
			return this.value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}

		@Override
		public String toString() {
			return key + " = " + value;
		}
	}

	private int index(K key) {
		return Math.abs(key.hashCode()) % table.length;
	}

	private Entry<K, V> find(int index, K key) {
		Entry<K, V> entry = (Entry<K, V>) table[index];
		while (entry != null) {
			if (entry.key.equals(key))
				return entry;
			entry = entry.next;
		}
		return null;
	}
}
