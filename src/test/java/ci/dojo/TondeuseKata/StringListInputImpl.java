package ci.dojo.TondeuseKata;

import ci.dojo.TondeuseKata.core.input.Input;

import java.util.Arrays;
import java.util.List;

public class StringListInputImpl implements Input {
    @Override
    public List<String> sharePosition() {
        return Arrays.asList(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        );
    }
}