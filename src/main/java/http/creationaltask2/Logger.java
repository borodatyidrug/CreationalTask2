package http.creationaltask2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Logger {
    
    protected long num = 1;
    private static Logger logger;
    
    private Logger() {}
    
    public static Logger getInstance() {
        return logger != null ? logger : (logger = new Logger());
    }
    
    private String dateGenerator() {  
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(
                FormatStyle.MEDIUM, FormatStyle.MEDIUM));
    }
    
    public void log(String message) {
        System.out.println("[" + dateGenerator() + " #" + num++ + "] " + message);
    }
}
