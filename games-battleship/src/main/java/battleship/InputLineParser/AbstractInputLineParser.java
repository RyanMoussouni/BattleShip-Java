package battleship.InputLineParser;

import java.text.ParseException;

public abstract class AbstractInputLineParser<TParsed> {
    protected final String rawLine;

    public AbstractInputLineParser(String rawLine) {
        this.rawLine = rawLine;
    }

    public abstract TParsed parse() throws ParseException;
}
