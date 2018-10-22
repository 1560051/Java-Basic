//cộng 1 giga giây với thời gian cho trước

import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {

    private LocalDateTime dateTime;

    Gigasecond(LocalDate birthDate) {
        this.dateTime=LocalDateTime.of(
                birthDate.getYear(),
                birthDate.getMonth(),
                birthDate.getDayOfMonth(),
                0,0,0);
    }

    Gigasecond(LocalDateTime birthDateTime) {
        this.dateTime=birthDateTime;
    }

    LocalDateTime getDateTime() {
        this.dateTime=this.dateTime.plusSeconds(1000000000);
        return this.dateTime;
    }

}
