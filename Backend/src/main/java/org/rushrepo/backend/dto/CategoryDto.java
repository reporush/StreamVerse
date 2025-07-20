package org.rushrepo.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private final String id;
    private String name;
    private String boxArtUrl;
}
