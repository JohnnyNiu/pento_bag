package com.bag.pin.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by johnny on 25/11/15.
 */
@Document(collection = "pin")
public class Pin {
    private String id;
    private String title;
    private String source;
    private Date date;
    private long favoriteTotal;
    private long like_total;
    private String pentoUserId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getFavoriteTotal() {
        return favoriteTotal;
    }

    public void setFavoriteTotal(long favoriteTotal) {
        this.favoriteTotal = favoriteTotal;
    }

    public long getLike_total() {
        return like_total;
    }

    public void setLike_total(long like_total) {
        this.like_total = like_total;
    }

    public String getPentoUserId() {
        return pentoUserId;
    }

    public void setPentoUserId(String pentoUserId) {
        this.pentoUserId = pentoUserId;
    }

    @Override
    public String toString() {
        return "Pin{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", date=" + date +
                ", favoriteTotal=" + favoriteTotal +
                ", like_total=" + like_total +
                ", pentoUserId='" + pentoUserId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pin pin = (Pin) o;

        if (favoriteTotal != pin.favoriteTotal) return false;
        if (like_total != pin.like_total) return false;
        if (id != null ? !id.equals(pin.id) : pin.id != null) return false;
        if (title != null ? !title.equals(pin.title) : pin.title != null) return false;
        if (source != null ? !source.equals(pin.source) : pin.source != null) return false;
        if (date != null ? !date.equals(pin.date) : pin.date != null) return false;
        return !(pentoUserId != null ? !pentoUserId.equals(pin.pentoUserId) : pin.pentoUserId != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (int) (favoriteTotal ^ (favoriteTotal >>> 32));
        result = 31 * result + (int) (like_total ^ (like_total >>> 32));
        result = 31 * result + (pentoUserId != null ? pentoUserId.hashCode() : 0);
        return result;
    }
}
