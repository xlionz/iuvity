package co.com.iuvity.certificacion.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonalInfo {

    private String firstName;
    private String lastName;
    private String zip;
}
