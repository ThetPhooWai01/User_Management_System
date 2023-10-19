package com.example.crud.test.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotBlank
    @Min(1)
    private int age;
    @NotNull
    @NotBlank
    @Min(1)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

}
