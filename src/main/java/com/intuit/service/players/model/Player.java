package com.intuit.service.players.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "players")
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String 	playerID	;
    private String 	birthYear	;
    private String 	birthMonth	;
    private String 	birthDay	;
    private String 	birthCountry	;
    private String 	birthState	;
    private String 	birthCity	;
    private String 	deathYear	;
    private String 	deathMonth	;
    private String 	deathDay	;
    private String 	deathCountry	;
    private String 	deathState	;
    private String 	deathCity	;
    private String 	nameFirst	;
    private String 	nameLast	;
    private String 	nameGiven	;
    private String 	weight	;
    private String 	height	;
    private String 	bats	;
    private String 	throwsId	;
    private String 	debut	;
    private String 	finalGame	;
    private String 	retroID	;
    private String 	bbrefID	;


}
