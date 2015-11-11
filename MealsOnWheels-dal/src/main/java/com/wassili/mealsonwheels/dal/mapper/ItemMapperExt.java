package com.wassili.mealsonwheels.dal.mapper;

import java.util.List;

import com.wassili.mealsonwheels.dal.model.Item;

public interface ItemMapperExt {
	
	List<Item> queryItem(Item item);

}
