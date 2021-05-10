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
public class MyFoodVO {
	private Integer my_seq; // NUMBER
	private String my_date; // CHAR(10)
	private String my_fcode; // CHAR(7)
    private Integer my_intake = 0; // NUMBER
}

