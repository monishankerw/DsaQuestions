package com.dsa.collectionInjava.lists;

import java.util.*;
import java.util.stream.IntStream;

public class Iterators {
    public static class ForEachWithIndex {
        public static void main(String[] args) {
            List<Integer> list = new ArrayList<>();

            // Populate the list
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }

            System.out.println("Original List: " + list);

            // Remove element at index 3 safely
            if (list.size() > 3) {
                list.remove(3);
            }

            // Print list using index-based loop
            System.out.println("List after removing index 3:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("Index " + i + ": " + list.get(i));
            }

            // Java 8 forEach with index using IntStream
            System.out.println("Using Java 8 IntStream to print with index:");
            IntStream.range(0, list.size())
                    .forEach(i -> System.out.println("Index " + i + " => " + list.get(i)));
        }
    }

    // ForEach
    public static class ForEach {
        public static void main(String[] args) {


            Arrays.asList("abc", "afg", "err", "abc", "wqe", "afg").forEach(System.out::println);
            //using for each: The for-each loop is a simple and readable way to iterate over elements in a list.
            // It does not allow modification of the list during iteration.
            List<Integer> list2 = Arrays.asList(1, 3, 2, 4, 2, 5);
            for (Integer num : list2) {
                System.out.println("Print List:" + num);
            }
        }

    }

    //2. Iterator
    //       The Iterator interface provides methods to iterate over a collection
    //       and allows safe removal of elements during iteration.
    public static class Iteerator {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1, 3, 2, 4, 2, 5);
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                System.out.println(next);
//            iterator.remove();
            }

        }
    }

    /*
              ListIterator: Bidirectional traversal and element modification.

        */
    public static class ListIteratorExample {
        public static void main(String[] args) {

            List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

            ListIterator<String> listIterator = list1.listIterator();

            System.out.println("Forward iteration and modification:");
            while (listIterator.hasNext()) {
                String item = listIterator.next();
                System.out.println("Current: " + item);

                // Optional: Modify elements during iteration
                if (item.equals("B")) {
                    listIterator.set("Beta");
                }
            }

            System.out.println("\nBackward iteration:");
            while (listIterator.hasPrevious()) {
                String item = listIterator.previous();
                System.out.println("Current: " + item);
            }

            System.out.println("\nFinal List: " + list1);
        }
    }

    /*
      Enumeration:        Enumeration: Used with legacy classes, no element removal.

       */
    public static class EnumerationExample {
        public static void main(String[] args) {

            Vector<String> vector = new Vector<>(Arrays.asList("A", "B", "C", "D"));
            Enumeration<String> enumeration = vector.elements();

            while (enumeration.hasMoreElements()) {
                String item = enumeration.nextElement();
                System.out.println(item);
            }
        }
    }
       /*     Cursor: Generally used for database operations, not for lists.
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

        while (resultSet.next()) {
            String data = resultSet.getString("column_name");
            System.out.println(data);
            }

         */
}
