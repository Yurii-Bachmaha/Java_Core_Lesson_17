package task01;

import task01.Iterator.Collection;

public class Application {

	public static void main(String[] args) {

		Integer[] array = { 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
		
		System.out.println("Show all array from the first to the last value and replace all odd numbers to null:");
		Collection collection = new Collection(array);
		Iterator iteratorForward = collection.createForwardIterator();

		while (iteratorForward.hasNext()) {
			Integer next = iteratorForward.next();
			if (next % 2 != 0) {
				next = null;
			} else {
				System.out.println(next);
			}
		}

		System.out.println("\nShow all array from the last to the first value through one digit:");
		Iterator iteratorBackward = collection.createBackwardIterator();

		while (iteratorBackward.hasNext()) {
			Integer next = iteratorBackward.next();

			System.out.println(next);
		}

		System.out.println("\nShow every third odd element of the array from the end:");
		Iterator anonymousIterator = collection.createAnonymousIterator();

		int count = 1;

		while (anonymousIterator.hasNext()) {
			Integer next = anonymousIterator.next();

			if (count % 3 == 0) {
				if (next % 2 != 0) {
					System.out.println(next);
				}
			}
			count++;
		}

		System.out.println("\nShow every fifth element of the array from the beginning , if it is even subtract 100:");
		Iterator localIterator = collection.createLocalIterator();

		int count2 = 1;

		while (localIterator.hasNext()) {
			Integer next = localIterator.next();
			if (count2 % 5 == 0) {
				if (next % 2 == 0) {
					System.out.println(next - 100);
				}
			}
			count2++;
		}

		System.out.println("\nShow all array , check every second element , if it is even - make it odd:");
		Iterator staticIterator = collection.createStaticIterator();

		int count3 = 0;

		while (staticIterator.hasNext()) {
			Integer next = staticIterator.next();
			if (count3 % 2 == 0) {
				if (next % 2 == 0) {
					System.out.println(next + 1);
				}
			} else {
				System.out.println(next);
			}
			count3++;
		}
	}
}