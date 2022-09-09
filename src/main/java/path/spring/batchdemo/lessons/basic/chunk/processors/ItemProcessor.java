package path.spring.batchdemo.lessons.basic.chunk.processors;

import org.springframework.stereotype.Component;

@Component
public class ItemProcessor implements org.springframework.batch.item.ItemProcessor<Integer, Integer> {

    @Override
    public Integer process(Integer item) throws Exception {
        return Integer.sum(item, 10);
    }

}
