package org.simplilearn.workshop.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.simplilearn.workshop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository(value = "cusomerRepository")
public class JdbcCustomerRepositoryImpl implements CustomerRepository {
	
	private static final String SELECT_ALL = "SELECT * FROM CUSTOMERS";
	private static final String INSERT_SQL = "INSERT INTO CUSTOMERS(NAME,PHONE,EMAIL) VALUES (?,?,?)";
	private DataSource dataSource;
	
	//spring-jdbc provides a class by name JdbcTemplate
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = jdbcTemplate.query(SELECT_ALL, new CustomerMapper());
		return customers;
	}

	@Override
	public void createCustomer(String name, String phone, String email) {
		jdbcTemplate.update(INSERT_SQL, name,phone,email);
	}

	@Override
	public Customer findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(String phone, String email) {
		// TODO Auto-generated method stub
		
	}

}
class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getLong("id"));
		customer.setName(rs.getString("name"));
		customer.setEmail(rs.getString("email"));
		customer.setPhone(rs.getString("phone"));
		return customer;
	}
	
}