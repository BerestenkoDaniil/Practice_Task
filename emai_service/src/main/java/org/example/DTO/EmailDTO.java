package org.example.DTO;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class EmailDTO {
    @NotNull
    private String username;

    @NotNull
    private String email;
}
