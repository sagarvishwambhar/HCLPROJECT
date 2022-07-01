package com.hclcv.generated.mapper;
import java.util.*;
import com.hclcv.generated.model.Skillsummary;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SkillsummaryMapper extends CrudRepository<Skillsummary, Long>{

	

	@Query(value = "SELECT * FROM skillsummary WHERE id = ?1 LIMIT 1 ", nativeQuery = true)
	Skillsummary getById1(@Param("id") Integer id);

	@Query(value = "SELECT * FROM skillsummary WHERE sapid = ?1", nativeQuery = true)
	List<Skillsummary> getSapid(@Param("sapid") String sapid);


	@Query(value = "DELETE FROM skillsummary WHERE id = #{id} ", nativeQuery = true)
	Integer deleteById1(@Param("id") Integer id);

	@Query(value = "UPDATE skillsummary SET stream=#{stream}, skills=#{skills}, selfproficiency=#{selfproficiency}, primaryskills=#{primaryskills}, sapid=#{sapid}, employeeid=#{employeeid} where id = #{id}", nativeQuery = true)
	Integer update1(Skillsummary skillsummary);


	


	@Query(value = "SELECT * FROM skillsummary LIMIT 10 ", nativeQuery = true)
	List<Skillsummary> list();

	
}