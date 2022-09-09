package path.spring.batchdemo.lessons.reader.csv.readers;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.support.AbstractItemStreamItemReader;

import java.util.Arrays;
import java.util.List;

public class CSVItemReader extends AbstractItemStreamItemReader {

    List<Integer> arrayStr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    Integer currentPos = -1;

    @Override
    public Object read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        currentPos++;
        return (currentPos < 10) ? arrayStr.get(currentPos) : null;
    }
}
