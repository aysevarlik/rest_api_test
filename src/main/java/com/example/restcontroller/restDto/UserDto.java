package com.example.restcontroller.restDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {

    private Long id;

    @NotEmpty(message = "kullanıcı adı giriniz!")
    @Size(max = 20,message = "kullanıcı adı maksimum 20 karakterli olmalıdır!")
    private String nickName;

    @NotEmpty(message = "şifre giriniz!")
    @Size(min = 8,max = 16,message = "şifre 8 ve 16 karakter arasında olmalıdır!")
    private String password;

    private Date createdDate;

}
