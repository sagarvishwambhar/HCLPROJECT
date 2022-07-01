package com.hclcv.generated.mapper;
import java.util.*;
import com.hclcv.generated.model.Ohterprojectdeatils;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface OhterprojectdeatilsMapper extends CrudRepository<Ohterprojectdeatils, Long>{



	@Query(value = "SELECT * FROM ohterprojectdeatils WHERE id = ?1 LIMIT 1 ", nativeQuery = true)
	Ohterprojectdeatils getById1(@Param("id") Integer id);

	@Query(value = "SELECT * FROM ohterprojectdeatils WHERE sapid = ?1", nativeQuery = true)
	List<Ohterprojectdeatils> getSapid(@Param("sapid") String sapid);


	@Query(value = "DELETE FROM ohterprojectdeatils WHERE id = #{id} ", nativeQuery = true)
	Integer deleteById1(@Param("id") Integer id);

	@Query(value = "UPDATE ohterprojectdeatils SET otherdetails=#{otherdetails}, otherdetails2=#{otherdetails2}, otherdetails3=#{otherdetails3}, otherdetails4=#{otherdetails4}, otherdetails5=#{otherdetails5}, sapid=#{sapid}, employeeid=#{employeeid} where id = #{id}", nativeQuery = true)
	Integer update1(Ohterprojectdeatils ohterprojectdeatils);




	@Query(value = "SELECT * FROM ohterprojectdeatils LIMIT 10 ", nativeQuery = true)
	List<Ohterprojectdeatils> list();

	
}