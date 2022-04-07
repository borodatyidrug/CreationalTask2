package http.creationaltask2;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    
    private final int treshold;
    private final Logger logger;
    private int discarded;
    private int accepted;
    
    public Filter(int threshold) {
        this.treshold = threshold;
        this.logger = Logger.getInstance();
    }
    
    public List<Integer> filter(List<Integer> source) {
        this.discarded = 0;
        this.accepted = 0;
        List<Integer> outputList = new ArrayList();
        logger.log("Начинаем фильтрацию элементов входного списка");
        source.stream()
                .forEach(i -> {
                    if(i < this.treshold) {
                        logger.log("Элемент \"" + i + "\" отбрасывается");
                        discarded++;
                    } else {
                        logger.log("Элемент \"" + i + "\" подходит");
                        outputList.add(i);
                        accepted++;
                    }
                });
        logger.log("Фильтрация окончена. Элементов отброшено/оставлено: " + discarded + "/" + accepted);
        return outputList;
    }
}
