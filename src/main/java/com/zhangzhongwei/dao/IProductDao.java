package com.zhangzhongwei.dao;

import com.zhangzhongwei.model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;



public interface IProductDao {
	/**
	 * Insert a product
	 * @return int
	 */
	int save(Product product, Connection con) throws SQLException;
	/**
	 * Delete a product by productId
	 * @return int
	 */
	int delete(Integer productId, Connection con) throws SQLException;
	/**
	 *	Update a product by productId
	 * @return int
	 */
	int update(Product instance, Connection con) throws SQLException;
	/**
	 *	Select a product by productId
	 * @return Product model
	 */
	Product findById(Integer productId, Connection con) throws SQLException;
	/**
	 * Select all product by categoryId
	 * @param categoryId
	 * @return List of product
	 */
	List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException;
	/**
	 * Select product by price between minprice and maxPrice
	 * @return List of product
	*/
	List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException;
	/**
	 * Find all products
	 * @return List of product
	 */
	List<Product> findAll(Connection con) throws SQLException;
	/**
	 * Select all product by name like
	 * @return List of product
	 */
	List<Product> findByProductName(String productName, Connection con) throws SQLException;
	/**
	 * Select all product by name like
	 * @return List of product
	 */
	List<Product> getPicture(Integer productId, Connection con) throws SQLException;
}
