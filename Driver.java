import java.util.*;

public class Driver {

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *


	Important: this Driver is contingent on your toString already working. If your toString is broken, you may recieve confusing results.


	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

	private static String message(String input, String desired, String output) {
		return String.format("\n%s\n\n\tDesired output:   %s\n\tYour output:      %s", input, desired, output);
	}

	private static String message(String input, Integer desired, Integer output) {
		return message(input, Integer.toString(desired), Integer.toString(output));
	}

	private static boolean edge_check(Deque<Integer> a, MyDeque<Integer> b) {
		if (a.size() == b.size() && a.size() == 0) return true;
		return a.getFirst().equals(b.getFirst()) && a.getLast().equals(b.getLast());
	}

	private static String gist_string(Deque<Integer> a) {
		String full = a.toString();
		if (full.length() < 45) return full;
		return full.substring(0, 15).trim()+" ... "+full.substring(full.length()-15, full.length()).trim();
	}

	private static String gist_string(MyDeque<Integer> a) {
		String full;
		try {full = a.toString();}
		catch (Exception e) {return "toString threw: "+e;}

		if (full.length() < 30) return full;
		return full.substring(0, 10).trim()+" ... "+full.substring(full.length()-10, full.length()).trim();
	}

	public static void main(String[] args) {
		ArrayList<String> out = new ArrayList<>();
		MyDeque<Integer> deque = new MyDeque<>();

		System.out.println("empty array");

		if (!deque.toString().equals("{}"))
    System.out.println(message("{}.toString()", "\"{}\"", "\""+deque.toString()+"\""));

		if (deque.size() != 0)
			System.out.println(message("{}.size()", 0, deque.size()));

		System.out.println("exception testing");

		try {
			deque.getFirst();
			System.out.println(message("{}.getFirst()", "NoSuchElementException", Integer.toString(deque.getFirst())));
		} catch (NoSuchElementException e) {}
		catch (Exception e) {
			System.out.println(message("{}.getFirst()", "NoSuchElementException", e.getClass().getSimpleName()));
		}

		try {
			deque.getLast();
			System.out.println(message("{}.getLast()", "NoSuchElementException", Integer.toString(deque.getLast())));
		} catch (NoSuchElementException e) {}
		catch (Exception e) {
			System.out.println(message("{}.getLast()", "NoSuchElementException", e.getClass().getSimpleName()));
		}

		try {
			deque.removeFirst();
			System.out.println(message("{}.removeFirst()", "NoSuchElementException", Integer.toString(deque.removeFirst())));
		} catch (NoSuchElementException e) {}
		catch (Exception e) {
			System.out.println(message("{}.removeFirst()", "NoSuchElementException", e.getClass().getSimpleName()));
		}

		try {
			deque.removeLast();
			System.out.println(message("{}.removeLast()", "NoSuchElementException", Integer.toString(deque.removeLast())));
		} catch (NoSuchElementException e) {}
		catch (Exception e) {
			System.out.println(message("{}.removeLast()", "NoSuchElementException", e.getClass().getSimpleName()));
		}

		try {
			deque.addFirst(null);
			System.out.println(message("{}.addFirst(null)", "NullPointerException", "you didn't throw anything"));
		} catch (NullPointerException e) {}
		catch (Exception e) {
			System.out.println(message("{}.addFirst(null)", "NullPointerException", e.getClass().getSimpleName()));
		}

		try {
			deque.addLast(null);
			System.out.println(message("{}.addLast(null)", "NullPointerException", "you didn't throw anything"));
		} catch (NullPointerException e) {}
		catch (Exception e) {
			System.out.println(message("{}.addLast(null)", "NullPointerException", e.getClass().getSimpleName()));
		}

		System.out.println("adding forward past capacity");

		Deque<Integer> comp = new ArrayDeque<>();

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.addLast(i);
				comp.addLast(i);
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".addLast("+i+")", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".addLast("+i+")\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".addLast("+i+")", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("removing from end without wrap");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.removeLast();
				comp.removeLast();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeLast()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeLast()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeLast()", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("adding backward past capacity");

		deque = new MyDeque<>();
		comp = new ArrayDeque<>();

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.addFirst(i);
				comp.addFirst(i);
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".addFirst("+i+")", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".addFirst("+i+")\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".addFirst("+i+")", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("removing from front without wrap");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.removeFirst();
				comp.removeFirst();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeFirst()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeFirst()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeFirst()", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("stepping forwards -- this should place us somewhere in the middle of the data array");

		deque = new MyDeque<>();
		comp = new ArrayDeque<>();

		for (int i = 0; i < 500; i++) {
			String old = gist_string(deque);
			try {
				deque.addLast(i);
				comp.addLast(i);
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".addLast("+i+")", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".addLast("+i+")\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".addLast("+i+")", gist_string(comp), e.toString()));
				break;
			}
			old = gist_string(deque);
			try {
				deque.removeFirst();
				comp.removeFirst();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeFirst()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeFirst()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeFirst()", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("adding forward to meet at middle");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.addLast(i);
				comp.addLast(i);
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".addLast("+i+")", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".addLast("+i+")\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".addLast("+i+")", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("removing from end with wrap");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.removeLast();
				comp.removeLast();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeLast()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeLast()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeLast()", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("stepping backwards -- this should place us somewhere in the middle of the data array");

		deque = new MyDeque<>();
		comp = new ArrayDeque<>();

		for (int i = 0; i < 500; i++) {
			String old = gist_string(deque);
			try {
				deque.addFirst(i);
				comp.addFirst(i);
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".addFirst("+i+")", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".addFirst("+i+")\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".addFirst("+i+")", gist_string(comp), e.toString()));
				break;
			}
			old = gist_string(deque);
			try {
				deque.removeLast();
				comp.removeLast();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeLast()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeLast()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeLast()", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("adding backward to meet at middle");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.addFirst(i);
				comp.addFirst(i);
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".addFirst("+i+")", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".addFirst("+i+")\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".addFirst("+i+")", gist_string(comp), e.toString()));
				break;
			}
		}

		System.out.println("removing from front with wrap");

		for (int i = 0; i < 1000; i++) {
			String old = gist_string(deque);
			try {
				deque.removeFirst();
				comp.removeFirst();
				if (!edge_check(comp, deque)) {
					System.out.println(message(old+".removeFirst()", gist_string(comp), gist_string(deque)));
					break;
				}
				if (comp.size() != deque.size()) {
					System.out.println(message(old+".removeFirst()\n"+gist_string(deque)+".size()", comp.size(), deque.size()));
					break;
				}
			} catch (Exception e) {
				System.out.println(message(old+".removeFirst()", gist_string(comp), e.toString()));
				break;
			}
		}
	}
}
