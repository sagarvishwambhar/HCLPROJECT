package com.hclcv.generated.mapper;
import java.util.*;
import com.hclcv.generated.model.Experiencesummary;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ExperiencesummaryMapper extends CrudRepository<Experiencesummary, Long>{



	@Query(value = "SELECT * FROM experiencesummary WHERE id = ?1 LIMIT 1 ", nativeQuery = true)
	Experiencesummary getById1(@Param("id") Integer id);
	
	
	@Query(value = "SELECT * FROM experiencesummary WHERE sapid = ?1", nativeQuery = true)
	List<Experiencesummary> getSapid(@Param("sapid") String sapid);


	@Query(value = "DELETE FROM experiencesummary WHERE id = #{id} ", nativeQuery = true)
	Integer deleteById1(@Param("id") Integer id);

	@Query(value = "UPDATE experiencesummary SET organisationname=#{organisationname}, designation=#{designation}, formdate=#{formdate}, todate=#{todate}, sapid=#{sapid}, employeeid=#{employeeid} where id = #{id}", nativeQuery = true)
	Integer update1(Experiencesummary experiencesummary);




	@Query(value = "SELECT * FROM experiencesummary LIMIT 10 ", nativeQuery = true)
	List<Experiencesummary> list();

	
}