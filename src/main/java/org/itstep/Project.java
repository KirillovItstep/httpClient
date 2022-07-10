package org.itstep;

public class Project {
    public boolean isInbox_project() {
        return inbox_project;
    }

    public void setInbox_project(boolean inbox_project) {
        this.inbox_project = inbox_project;
    }

    public Project(long id, int order, int color, String name, int comment_count, boolean shared, boolean favorite, int sync_id, String url, boolean inbox_project) {
        this.id = id;
        this.order = order;
        this.color = color;
        this.name = name;
        this.comment_count = comment_count;
        this.shared = shared;
        this.favorite = favorite;
        this.sync_id = sync_id;
        this.url = url;
        this.inbox_project = inbox_project;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public void setSync_id(int sync_id) {
        this.sync_id = sync_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private long id;
    private int order;
    private int color;
    private String name;
    private int comment_count;
    private boolean shared;
    private boolean favorite;
    private int sync_id;
    private String url;
    private boolean inbox_project;



    public Project() {

    }

    public long getId() {
        return id;
    }

    public int getOrder() {
        return order;
    }

    public int getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getComment_count() {
        return comment_count;
    }

    public boolean isShared() {
        return shared;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public int getSync_id() {
        return sync_id;
    }

    public String getUrl() {
        return url;
    }
}
