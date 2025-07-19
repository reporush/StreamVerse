package org.rushrepo.backend.dto;

public class CategoryDto {
    private final String id;
    private String name;
    private String boxArtUrl;

    public CategoryDto(String id, String name, String boxArtUrl) {
        this.id = id;
        this.name = name;
        this.boxArtUrl = boxArtUrl;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBoxArtUrl() {
        return boxArtUrl;
    }
    public void setBoxArtUrl(String boxArtUrl) {
        this.boxArtUrl = boxArtUrl;
    }   
}
