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
public class MyFoodDTO {
    private String my_date; // 날짜
    private String fd_code; // 식품코드
    private String fd_name; // 식품명
    private Integer my_intake; // 섭취량
    private Integer fd_content; // 총내용량(g)
    private Integer fd_calories; // 에너지(kcal)
    private Integer fd_protein; // 단백질(g)
    private Integer fd_fat; // 지방(g)
    private Integer fd_carbo; // 탄수화물(g)
    private Integer fd_sugar; // 총당류(g)
}

