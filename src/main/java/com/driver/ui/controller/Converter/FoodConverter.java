package com.driver.ui.controller.Converter;

import com.driver.model.request.FoodDetailsRequestModel;
import com.driver.model.response.FoodDetailsResponse;
import com.driver.shared.dto.FoodDto;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class FoodConverter {
    public static FoodDto foodRequestToDto(FoodDetailsRequestModel foodDetailsRequestModel)
    {
        FoodDto foodDto = FoodDto.builder()
                .foodName(foodDetailsRequestModel.getFoodName())
                .foodPrice(foodDetailsRequestModel.getFoodPrice())
                .foodCategory(foodDetailsRequestModel.getFoodCategory()).build();
        return foodDto;
    }
    public static FoodDetailsResponse dtoToResponse(FoodDto foodDto)
    {
        FoodDetailsResponse foodDetailsResponse = FoodDetailsResponse.builder().
                foodCategory(foodDto.getFoodCategory()).
                foodName(foodDto.getFoodName()).
                foodPrice(foodDto.getFoodPrice()).
                foodId(foodDto.getFoodId()).
                build();
        return  foodDetailsResponse;
    }

}
