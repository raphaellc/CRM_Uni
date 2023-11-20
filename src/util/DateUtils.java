package util;

import static util.ValorUtil.isEmptyString;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static String transformDateTime(final LocalDateTime data) {
        final SimpleDateFormat formatData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date = Date.from(data.atZone(ZoneId.systemDefault()).toInstant());
        return formatData.format(date);
    }

    public static LocalDate transformToDate(final String data) {
        if (isEmptyString(data)) {
            return null;
        }

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatter);
    }
}
