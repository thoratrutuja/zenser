package com.dao;
import java.util.List;
import com.model.*;
public interface Restaurantdao {
	public void  addRestaurant();
	public boolean updateRestaurant(int Rid,String Rname);
	public boolean deleteRestaurant (String Rname);
	public List<Restaurant> getAllRestaurant();
	
}