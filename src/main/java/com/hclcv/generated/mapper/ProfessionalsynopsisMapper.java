package com.hclcv.generated.mapper;
import java.util.*;
import com.hclcv.generated.model.Professionalsynopsis;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessionalsynopsisMapper extends CrudRepository<Professionalsynopsis, Long>{



	@Query(value = "SELECT * FROM professionalsynopsis WHERE id = ?1 LIMIT 1 ", nativeQuery = true)
	Professionalsynopsis getById1(@Param("id") Integer id);

	
	@Query(value = "SELECT * FROM professionalsynopsis WHERE sapid = ?1", nativeQuery = true)
	List<Professionalsynopsis> getSapid(@Param("sapid") String sapid);

	@Query(value = "DELETE FROM professionalsynopsis WHERE id = #{id} ", nativeQuery = true)
	Integer deleteById1(@Param("id") Integer id);

	@Query(value = "UPDATE professionalsynopsis SET synopsistext=#{synopsistext}, sapid=#{sapid}, employeeid=#{employeeid}, status=#{status} where id = #{id}", nativeQuery = true)
	Integer update1(Professionalsynopsis professionalsynopsis);




	@Query(value = "SELECT * FROM professionalsynopsis LIMIT 10 ", nativeQuery = true)
	List<Professionalsynopsis> list();

	
}