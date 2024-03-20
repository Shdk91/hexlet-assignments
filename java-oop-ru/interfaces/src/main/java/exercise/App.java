package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static List<String> buildApartmentsList(List<Home> apartments, int n) {

    List<Home> list = new ArrayList<>(apartments);
    Collections.sort(list, Comparator.comparing(Home::getArea));

    return list.subList(0, n).stream().map(Home::toString).toList();

    }
}
// END
