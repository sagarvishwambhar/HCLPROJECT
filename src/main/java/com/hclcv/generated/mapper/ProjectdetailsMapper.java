package com.hclcv.generated.mapper;
import java.util.*;
import com.hclcv.generated.model.Projectdetails;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectdetailsMapper extends CrudRepository<Projectdetails, Long>{



	@Query(value = "SELECT * FROM projectdetails WHERE id = ?1 LIMIT 1 ", nativeQuery = true)
	Projectdetails getById1(@Param("id") Integer id);


	@Query(value = "SELECT * FROM projectdetails WHERE sapid = ?1", nativeQuery = true)
	List<Projectdetails> getSapid(@Param("sapid") String sapid);

	
	@Query(value = "DELETE FROM projectdetails WHERE id = #{id} ", nativeQuery = true)
	Integer deleteById1(@Param("id") Integer id);

	@Query(value = "UPDATE projectdetails SET projectdetails=#{projectdetails}, duration=#{duration}, teamsize=#{teamsize}, roleposition=#{roleposition}, projectdescription=#{projectdescription}, technicalenvironment=#{technicalenvironment}, responsibility=#{responsibility}, sapid=#{sapid}, employeeid=#{employeeid} where id = #{id}", nativeQuery = true)
	Integer update1(Projectdetails projectdetails);




	@Query(value = "SELECT * FROM projectdetails LIMIT 10 ", nativeQuery = true)
	List<Projectdetails> list();

	
}