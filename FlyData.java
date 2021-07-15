package project2;

import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Scanner;
import static java.util.stream.Collectors.groupingBy;
import java.util.stream.Stream;

// Класс для ответов - методов
public class FlyData {

    ArrayList<String> base = new ArrayList<>();

    public FlyData() {
    }

    ArrayList<String> readBase(String fileName) {

        File inputFile = new File(fileName);

        // Reads in the data
        try (Scanner in = new Scanner(inputFile)) {

            while (in.hasNextLine()) {
                base.add(in.nextLine());
            }

        } catch (IOException e) {

            System.out.println("Check that your file is being written properly!");
        }
        base.remove(0);

        return this.base;

    }

    public static String FirstAnswer(ArrayList<String> base) {

        String k
                = base.stream()
                        .map(t -> t.split(","))
                        .map(e -> new AviaData(e))
                        .collect(groupingBy(e -> e.getUniqueCarrier()))
                        .entrySet()
                        .stream()
                        .map(e -> {
                            int a = e.getValue().size();
                            return new HashMap.SimpleEntry<>(e.getKey(), e.getValue()
                                    .stream()
                                    .filter(t -> t.getCancelled())
                                    .count() * 100.0 / a
                            );
                        }
                        )
                        .reduce((x, y) -> x.getValue() < y.getValue() ? y : x)
                        .map(e -> e.getKey() + ", " + String.format(Locale.ENGLISH, "%.2f", e.getValue()) + "%")
                        .get();
        return k;

    }

    public static String SecondAnswer(ArrayList<String> base) {

        String k
                = base.stream()
                        .map(t -> t.split(","))
                        .map(e -> new AviaData(e))
                        .filter(e -> !e.getCancellationCode().equals(""))
                        .collect(groupingBy(e -> e.getCancellationCode()))
                        .entrySet()
                        .stream()
                        .map(e -> new HashMap.SimpleEntry<>(e.getKey(), e.getValue().size()))
                        .reduce((x, y) -> x.getValue() < y.getValue() ? y : x)
                        .map(e -> e.getKey())
                        .get();
        return k;

    }

    public static String ThirdAnswer(ArrayList<String> base) {

        String k
                = base.stream()
                        .map(t -> t.split(","))
                        .map(e -> new AviaData(e))
                        .filter(e -> !e.getCancelled())
                        .collect(groupingBy(e -> e.getTailNum()))
                        .entrySet()
                        .stream()
                        .map(e -> new HashMap.SimpleEntry<>(e.getKey(), e.getValue()
                                  .stream()
                                  .mapToInt(t -> t.getDistance())
                                  .reduce((x, y) -> x + y))
                        )
                        .reduce((x, y) -> x.getValue().getAsInt() < y.getValue().getAsInt() ? y : x)
                        .map(e -> e.getKey())
                        .get();
        return k;

    }

    public static String FourthAnswer(ArrayList<String> base) {

        String a
                = base.stream()
                        .map(t -> t.split(","))
                        .map(e -> new AviaData(e))
                        .filter(e -> !e.getCancelled())
                        .flatMap(e -> Stream.of(new Airport("origin", e.getOriginAirportID()), new Airport("dest", e.getDestAirportID())))
                        .collect(groupingBy((t -> t.getAirportType())))
                        .entrySet()
                        .stream()
                        .map(r -> new HashMap.SimpleEntry<>(r.getKey(), r.getValue()
                                 .stream()
                                 .collect(groupingBy((t -> t.getAirportId())))
                                 .entrySet()
                                 .stream()
                                 .map(e -> new HashMap.SimpleEntry<>(e.getKey(), e.getValue().size()))
                         ))
                        .flatMap(e -> e.getValue())
                        .collect(groupingBy(r -> r.getKey()))
                        .entrySet()
                        .stream()
                        .map(r -> new HashMap.SimpleEntry<>(r.getKey(), r.getValue()
                                 .stream()
                                 .map(t -> t.getValue())
                                 .reduce(0, (x, y) -> x + y)
                          ))
                        .reduce((x, y) -> x.getValue() < y.getValue() ? y : x)
                        .map(e -> e.getKey())
                        .get();
        return a;

    }

    public static String FivethAnswer(ArrayList<String> base) {

        String a
                = base.stream()
                        .map(t -> t.split(","))
                        .map(e -> new AviaData(e))
                        .filter(e -> !e.getCancelled())
                        .flatMap(e -> Stream.of(new Airport("origin", e.getOriginAirportID()), new Airport("dest", e.getDestAirportID())))
                        .collect(groupingBy((t -> t.getAirportType())))
                        .entrySet()
                        .stream()
                        .map(r -> new HashMap.SimpleEntry<>(r.getKey(), r.getValue()
                                 .stream()
                                 .collect(groupingBy((t -> t.getAirportId())))
                                 .entrySet()
                                 .stream()
                                 .map(e -> new Airport(r.getKey(), e.getKey(), e.getValue().size()//)
                                   ))
                         ))
                        .flatMap(e -> e.getValue())
                        .collect(groupingBy((t -> t.getAirportId())))
                        .entrySet()
                        .stream()
                        .map(e -> new HashMap.SimpleEntry<>(e.getKey(), e.getValue()
                                .stream()
                                .map(k -> k.airportType.equals("origin") ? k.getCount() : -k.getCount())
                                .reduce((x, y) -> x + y)
                         ))
                        .reduce((x, y) -> x.getValue().get() < y.getValue().get() ? y : x)
                        .map(e -> e.getKey())
                        .get();
        return a;

    }

    public static String SixthAnswer(ArrayList<String> base) {

        String a
                = base.stream()
                        .map(t -> t.split(","))
                        .map(e -> new AviaData(e))
                        .filter(e -> !e.getCancelled())
                        .flatMap(e -> Stream.of(new Airport("origin", e.getOriginAirportID()), new Airport("dest", e.getDestAirportID())))
                        .collect(groupingBy((t -> t.getAirportType())))
                        .entrySet()
                        .stream()
                        .map(r -> new HashMap.SimpleEntry<>(r.getKey(), r.getValue()
                                .stream()
                                .collect(groupingBy((t -> t.getAirportId())))
                                .entrySet()
                                .stream()
                                .map(e -> new Airport(r.getKey(), e.getKey(), e.getValue().size()   ))
                         ))
                        .flatMap(e -> e.getValue())
                        .collect(groupingBy((t -> t.getAirportId())))
                        .entrySet()
                        .stream()
                        .map(e -> new HashMap.SimpleEntry<>(e.getKey(), e.getValue()
                                .stream()
                                .map(k -> k.airportType.equals("origin") ? -k.getCount() : k.getCount())
                                .reduce((x, y) -> x + y)
                        ))
                        .reduce((x, y) -> x.getValue().get() < y.getValue().get() ? y : x)
                        .map(e -> e.getKey())
                        .get();
        return a;

    }

    public static String SeventhAnswer(ArrayList<String> base) {

        long a
                = base.stream()
                        .map(t -> t.split(","))
                        .filter(e -> !e[12].equals(""))
                        .filter(e -> !e[16].equals(""))
                        .map(e -> new AviaData(e))
                        .filter(t -> !t.getCancelled())
                        .filter(e -> e.getUniqueCarrier().equals("AA"))
                        .filter(e -> e.getDelay() > 60)
                        .mapToInt(t -> t.getDelay())
                        .count();
        return String.valueOf(a);

    }

    public static String EightAnswer(ArrayList<String> base) {

        AviaData a
                = base.stream()
                        .map(t -> t.split(","))
                        .filter(e -> !e[12].equals(""))
                        .filter(e -> !e[16].equals(""))
                        .map(e -> new AviaData(e))
                        .filter(t -> !t.getCancelled())
                        .filter(e -> e.getArrDelay() <= 0)
                        .reduce((x, y) -> x.getDepDelay() > y.getDepDelay() ? x : y)
                        .get();

        return a.getDayofMonth() + "," + a.getDepDelay().toString() + "," + a.getTailNum();
    }

    public static String NinethAnswer(ArrayList<String> base) {

        AviaData a
                = base.stream()
                        .map(t -> t.split(","))
                        .filter(e -> !e[12].equals(""))
                        .filter(e -> !e[16].equals(""))
                        .map(e -> new AviaData(e))
                        .filter(t -> !t.getCancelled())
                        .filter(e -> e.getDelay() <= 0)
                        .collect(groupingBy(e -> e.getDelay()))
                        .entrySet()
                        .stream()
                        .sorted((x, y) -> x.getKey())
                        .findFirst()
                        .get()
                        .getValue()
                        .stream()
                        .findFirst()
                        .get();

        return a.getDayofMonth() + "," + a.getDepDelay() + "," + a.getTailNum();
    }
}
