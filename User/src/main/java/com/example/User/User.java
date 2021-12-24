package com.example.User;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private int id;

}
