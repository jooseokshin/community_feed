package org.community.post.domain.common;

import java.time.LocalDateTime;

public class DatetimeInfo {

    private boolean isEdited;
    private LocalDateTime dateTime;

    public DatetimeInfo() {
        this.dateTime = LocalDateTime.now();
        this.isEdited = false;
    }

    public void updateEditDatetime() {
        this.dateTime = LocalDateTime.now();
        this.isEdited = true;
    }

    public boolean isEdited() {
        return isEdited;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
