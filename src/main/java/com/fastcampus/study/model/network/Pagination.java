package com.fastcampus.study.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain =true)
public class Pagination {

    private Integer totalPages;

    private Long totalElements;

    private Integer currentPages;

    private Integer currentElements;
}
