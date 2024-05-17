package com.ecomerce.android.responsitory;

import com.ecomerce.android.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query(value = "Update customer set fullname = ?1, address = ?2, phonenumber = ?3, province = ?4, district = ?5, subdistrict = ?6 where user_name = ?7", nativeQuery = true)
    int UpdateCustomer(String fullname, String address, String phonenumber, String province, String district, String subdistrict, String username);
}
