package com.hclcv.generated.mapper;
import java.util.*;
import com.hclcv.generated.model.Education;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EducationMapper extends CrudRepository<Education, Long>{


	@Query(value = "SELECT * FROM education WHERE id = ?1 LIMIT 1 ", nativeQuery = true)
	Education getById1(@Param("id") Integer id);


	@Query(value = "DELETE FROM education WHERE id = ?1", nativeQuery = true)
	Integer deleteById1(@Param("id") Integer id);

	@Query(value = "UPDATE education SET degreecertificate=#{degreecertificate}, discipline=#{discipline}, instituteoruniversity=#{instituteoruniversity}, yearofpassing=#{yearofpassing}, sapid=#{sapid}, employeeid=#{employeeid} where id = #{id}", nativeQuery = true)
	Integer update1(Education education);



	@Query(value = "SELECT * FROM education WHERE sapid = ?1 ", nativeQuery = true)
	List<Education> getSapid(@Param("sapid") String sapid);


	@Query(value = "SELECT * FROM education LIMIT 10 ", nativeQuery = true)
	List<Education> list();

	
}