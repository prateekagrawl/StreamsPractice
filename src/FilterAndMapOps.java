import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterAndMapOps {
    public static void main(String[] args) {
        String[] arr = new String[]{"Hello", "Stream", "APIs"};
        //calculate no. of strings with length > 4

        System.out.println("Number of Stream Elements with length 4 = " +
        Arrays.stream(arr).filter(s -> s.length()>4 ).count()
                );

        System.out.println("****************************");
        //used to transform each element in a stream.
        //to transform a list of integers to square of them

        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        List<Integer> sqNumbers = numbers.stream().map(n -> n*2)
                .collect(Collectors.toList());
        System.out.println("Square numbers: "+ sqNumbers);

        //converting array of strings to length of them
        System.out.println("****************************");
        List<String> words = Arrays.asList("hello", "world", "java", "stream");

        List<Integer> wordsLength = words.stream()
                                    .map(word-> word.length())
                                .collect(Collectors.toList());

        System.out.println("Length of words: "+ wordsLength);

        System.out.println("****************************");
        List<String> wordsInUC = words.stream().map(s->s.toUpperCase(Locale.ROOT))
                .collect(Collectors.toList());
        System.out.println("Upper case strings: "+ wordsInUC);

        String[] streamArr = new String[]{"Hello", "Stream", "APIs"};

        Stream<String> stringStream = Arrays.stream(streamArr);
        System.out.println("Stream before filter : " + stringStream.count());

        //returns IllegalStateException - stream has already been operated upon or closed
//        stringStream = stringStream.filter(s -> s.length() > 4);
//        System.out.println("Stream after filter : " + stringStream.count());

        //concatenate a list of cities using java8
//        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Lko");
//        String res = cities.stream().collect(Collectors.joining(-));
//        System.out.println("Result is: "+ res);


        //--------------------------
        //Write function to return output in the following format:
        //inputArrayList= [1,3,2,4,3,1,2]
        //outputArrayList = [4,3,2,1]

        final List<Integer> inputArrayList = Arrays.asList(1, 3, 2, 4, 3, 1, 2);
        final List<Integer> outputArrayList = inputArrayList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(outputArrayList);  // Output: [4, 3, 2, 1]

        System.out.println("****************************");

        List<String> listOfWords = Arrays.asList("apple", "banana", "watermelon", "kiwi", "strawberry");
        listOfWords.sort(Comparator.comparingInt(String::length));
        listOfWords.forEach(s-> System.out.print(s+ " "));

        List<String> strWrods = Arrays.asList("apple", "banana", "watermelon", "kiwi", "strawberry");
        System.out.println("\n Count of strings" + strWrods.stream().count());
    }
}