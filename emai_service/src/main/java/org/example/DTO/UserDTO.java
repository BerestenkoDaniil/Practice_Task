package org.example.DTO;

import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class UserDTO {
    @NonNull
    private Long userId;

    @NonNull
    private String subject;

    @NonNull
    private String body;
}
