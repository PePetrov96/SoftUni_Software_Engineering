package com.example.football.models.dto.player;

import com.example.football.models.entity.enums.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerCreateDTO {
    @XmlElement(name = "first-name")
    @Size(min = 2)
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 2)
    private String lastName;

    @XmlElement(name = "email")
    @Email
    private String email;

    @XmlElement(name = "birth-date")
    private String birthDate;

    @XmlElement(name = "position")
    private Position position;

    @XmlElement
    private PlayerTownCreateDTO town;

    @XmlElement
    private PlayerTeamCreateDTO team;

    @XmlElement
    private PlayerStatCreateDTO stat;

}
