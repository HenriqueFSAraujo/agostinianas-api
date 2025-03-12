package com.agostinianas.demo.core.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;


@JsonInclude(Include.NON_NULL)
@Getter
@Builder
@Data
public class MessageResponse {

    private Integer status;
    private String type;
    private String title;
    private String detail;
    private String userMessage;
    private OffsetDateTime timestamp;

    private HashMap<String, List<String>> objects;
    private HashMap<String, String> object;

}
