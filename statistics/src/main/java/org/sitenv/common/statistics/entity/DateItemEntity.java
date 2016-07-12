package org.sitenv.common.statistics.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class DateItemEntity {
	private Date date;

    /**
     * @return the date
     */
    @Id
    @Column(name = "currtime")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
