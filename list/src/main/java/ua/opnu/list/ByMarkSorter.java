package ua.opnu.list;

import java.util.Comparator;

public class ByMarkSorter implements Comparator {

    private boolean order;

    public ByMarkSorter(boolean order) {
        this.order = order;
    }

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Student && o2 instanceof Student) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            Comparator<Double> ByMarkSorter = Comparator.nullsLast(Comparator.naturalOrder());

            if (order) { // Сортировка по возрастанию
                return ByMarkSorter.compare(s1.getAvgMark(), s2.getAvgMark());
            } else { // Сортировка по убыванию
                return ByMarkSorter.compare(s2.getAvgMark(), s1.getAvgMark());
            }

        }
        return 0;
    }
}
