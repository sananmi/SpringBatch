package path.spring.batchdemo.lessons.basic.chunk.writers;

import org.springframework.batch.item.support.AbstractItemStreamItemWriter;

import java.util.List;

public class ItemWriter extends AbstractItemStreamItemWriter {
    @Override
    public void write(List items) throws Exception {
        items.stream().forEach(System.out::println);
        System.out.println("writing each chunk");
    }
}
