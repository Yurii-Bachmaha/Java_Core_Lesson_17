package task01;

public interface Iterator {

	public boolean hasNext();
	public Integer next();

	class Collection {
		private static Integer[] array;

		Collection(Integer[] array) {
			Collection.array = array;
		}

		public class Forward implements Iterator {

			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < array.length;
			}

			@Override
			public Integer next() {
				return array[count++];
			}
		}

		public Forward createForwardIterator() {
			return new Forward();
		}

		public class Backward implements Iterator {

			private int count = array.length - 1;

			@Override
			public boolean hasNext() {
				return count >= 0;
			}

			@Override
			public Integer next() {
				count = count - 2;
				return array[count + 2];
			}
		}

		public Backward createBackwardIterator() {
			return new Backward();
		}
		
		public Iterator createAnonymousIterator() {
			return new Iterator() {

				private int count = array.length-1;
				
				@Override
				public boolean hasNext() {
					return count>=0;
				}

				@Override
				public Integer next() {
					return array[count --];
				}
			};
		}
		
		public Iterator createLocalIterator() {
			class localIterator implements Iterator{

				private int count = 0;
				
				@Override
				public boolean hasNext() {
					return count < array.length;
				}

				@Override
				public Integer next() {
					return array[count++];
				}
				
			}
			return new localIterator();
		}
		
		private static class staticIterator implements Iterator{
			
			private int count = 0;

			@Override
			public boolean hasNext() {
				return count < array.length;
			}

			@Override
			public Integer next() {
				return array[count++];
			}
			
		}
		
		public staticIterator createStaticIterator() {
			return new staticIterator();
		}
	}
}