package util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

    public static String transformDateTime(final LocalDateTime data) {
        final SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = Date.from(data.atZone(ZoneId.systemDefault()).toInstant());
        return formatData.format(date);
    }
}
