package com.dao;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import com.configuration.ConnectionRestaurant;
import com.model.Restaurant;

public class RestaurantDaoImplements implements Restaurantdao {
	static RestaurantDaoImplements restaurantDaoImplements = null;
	static Connection con = null;

	public static RestaurantDaoImplements getInstance() {
		if (restaurantDaoImplements == null) {
			restaurantDaoImplements = new RestaurantDaoImplements();
		}
		return restaurantDaoImplements;
	}

	public void addRestaurant() {
		// PreparedStatement preparedStatement=null;
		try {
			con = ConnectionRestaurant.getConnection();
			// System.out.println("enter restaurant id,name,opentime,closetime,phone
			// no,address,cuisine");
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO restaurant VALUES(?,?,?,?,?,?,?)");
			Scanner sc = new Scanner(System.in);
			 System.out.println("Enter Restaurant id");
			 int Rid=sc.nextInt();
			System.out.println("Enter Restaurant name");
			String Rname = sc.next();
			System.out.println("Restaurant address");
			String Radd = sc.next();
			System.out.println("Restaurant Contact");
			long mb = sc.nextLong();
			System.out.println("Enter Restaurant opening time");
			int openhh = sc.nextInt();
			int openmm = sc.nextInt();
			System.out.println("Enter Restaurant closing time");
			int closehh = sc.nextInt();
			int closemm = sc.nextInt();
			LocalTime openingTime = LocalTime.of(openhh, openmm);
			LocalTime closeingTime = LocalTime.of(closehh, closemm);
			System.out.println("Restaurant Cuisine(ITALIAN/MEXICAN/INDIAN/CHINESE)");
			String cuisine = sc.next();
		    preparedStatement.setInt(1,Rid);
			preparedStatement.setString(2, Rname);
			preparedStatement.setString(3, Radd);
			preparedStatement.setObject(5, openingTime);
			preparedStatement.setObject(6, closeingTime);
		    preparedStatement.setLong(4, mb);
			preparedStatement.setString(7, cuisine);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				System.out.println("Restaurant Added");
			} else {
				System.out.println("Restaurant Not Added");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e3) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {

		}
	}

	public boolean updateRestaurant(int Rid,String Rname) {

		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement stat = null;
		try {
			con = ConnectionRestaurant.getConnection();
			String sql = "UPDATE restaurant SET  Rname=? WHERE Rid=?";
			stat=con.prepareStatement(sql);
			stat.setString(1,Rname);
			stat.setInt(2,Rid);
			
			int rowsAffected = stat.executeUpdate();
			System.out.println("Rows affected:" + rowsAffected);
			System.out.println("update successfully");
			return true;

		} catch (Exception e4) {
			e4.printStackTrace();
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

	public boolean deleteRestaurant(String rname) {
		Connection con = null;
		PreparedStatement stat = null;
		try {
			con = ConnectionRestaurant.getConnection();
		
			String sql = "DELETE FROM restaurant WHERE Rname=?";
			stat =con.prepareStatement(sql);
			stat.setString(1,rname);
			int numberAffected = stat.executeUpdate();
			System.out.println("Rows affected:" + numberAffected);
			System.out.println("delete successfully");
			return true;

		} catch (Exception e5) {
			e5.printStackTrace();
		} 
		finally 
			{
				if (stat != null)
				{
					try {
						stat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		}
return false;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
	ArrayList<Restaurant> al=new ArrayList<>();
	try(Connection con=ConnectionRestaurant.getConnection();Statement st=con.createStatement())
	{
		ResultSet rs=st.executeQuery("select * from restaurant");
		while(rs.next())
		{
			Restaurant r=new Restaurant();
			r.setRid(rs.getInt(1));
			r.setRname(rs.getString(2));
			r.setRadd(rs.getString(3));
			r.setRphno(rs.getLong(4));
			r.setOpeningTime(rs.getTime(5).toLocalTime());
			r.setClosingTime(rs.getTime(6).toLocalTime());
			r.setCuisine(rs.getString(7));
			
			al.add(r);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return al;

	}

	 	


}



