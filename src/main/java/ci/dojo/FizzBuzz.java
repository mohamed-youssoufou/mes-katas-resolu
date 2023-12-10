package ci.dojo;

public class FizzBuzz {
    public String generate(int from, int to) {
        return evaluateNumbers(from, to);
    }

    private static String evaluateNumbers(int from, int to) {
        StringBuilder resolved = new StringBuilder();
        while(from <= to)
            resolved.append(evaluateNumber(from++));
        return resolved.toString();
    }

    private static String evaluateNumber(int from) {
        if(from % 15 == 0)
            return "FizzBuzz";
        if(from % 3 == 0)
            return "Fizz";
        if(from % 5 == 0)
            return "Buzz";
        return String.valueOf(from);
    }
}
