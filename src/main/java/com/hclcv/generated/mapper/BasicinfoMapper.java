package com.hclcv.generated.mapper;
import java.util.*;
import com.hclcv.generated.model.Basicinfo;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BasicinfoMapper extends CrudRepository<Basicinfo, Long>{



	@Query(value = "SELECT * FROM basicinfo WHERE id = ?1 LIMIT 1 ", nativeQuery = true)
	Basicinfo getById1(@Param("id") Integer id);

	@Query(value = "SELECT * FROM basicinfo WHERE sapid = ?1 LIMIT 1 ", nativeQuery = true)
	Basicinfo getSapid(@Param("sapid") String sapid);


	@Query(value = "DELETE FROM basicinfo WHERE id = #{id} ", nativeQuery = true)
	Integer deleteById1(@Param("id") Integer id);

	@Query(value = "UPDATE basicinfo SET sapid=#{sapid}, employeename=#{employeename}, currentworklocation=#{currentworklocation}, emailid=#{emailid}, mobileno=#{mobileno}, currentaddress=#{currentaddress}, dateofjoining=#{dateofjoining}, domainname=#{domainname}, datetime=#{datetime}, status=#{status}, photopath=#{photopath} where id = #{id}", nativeQuery = true)
	Integer update1(Basicinfo basicinfo);


	@Query(value = "SELECT * FROM basicinfo LIMIT 10 ", nativeQuery = true)
	List<Basicinfo> list();

	
}