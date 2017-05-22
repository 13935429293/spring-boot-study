package org.ywb.study.ch1;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class TestMap {

	private Object reference;

	class Person {

		private int id;

		private String name;

		public Person(int id, String name) {
            this.id = id;
			this.name = name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object object) {
			if (this == object)
				return true;
			if (object == null)
				return false;
			if (getClass() != object.getClass())
				return false;
			Person other = (Person) object;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private TestMap getOuterType() {
			return TestMap.this;
		}

	}

	@Test
	public void testPerformance() {

		ConcurrentHashMap<Person, Object> map = new ConcurrentHashMap<>();
		for (int index = 0; index < 10000000; index++) {
			Object object = new Object();
			Person key = new Person(index, String.valueOf(index));

			Object old = map.putIfAbsent(key, object);
			reference = (old == null ? object : old);
			 // reference = map.get(key);
		}

		System.out.println(map.size());
		System.out.println(reference);
	}

}
