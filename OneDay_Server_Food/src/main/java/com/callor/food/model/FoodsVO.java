package com.callor.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class FoodsVO {
    String fd_code;	    // CHAR(7)		PRIMARY KEY
    String fd_name;	    // nVARCHAR2(100)	NOT NULL
    String fd_year;	    // CHAR(4)	NOT NULL
    String fd_ccode;    	// CHAR(6)	NOT NULL
    String fd_icode;    	// CHAR(4)	NOT NULL
    Integer fd_container;	// NUMBER
    Integer fd_content;	// NUMBER	NOT NULL
    Integer fd_calories;	// NUMBER
    Integer fd_protein;	// NUMBER
    Integer fd_fat;	    // NUMBER
    Integer fd_carbo;	// NUMBER
    Integer fd_sugar;	// NUMBER
}
