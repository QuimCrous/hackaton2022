package com.hackaton2022.hackaton2022.repositories;

import com.hackaton2022.hackaton2022.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    @Query(value = "SELECT * FROM company.company ORDER BY (CASE size when '10001+' then 1 when '5001-10000' then 2 when '1001-5000' then 3 when '501-1000' then 4 when '201-500' then 5 when '51-200' then 6 when '11-50' then 7 when '1-10' then 8 end) ASC, size DESC",nativeQuery = true )
    List<Company> findAllBySizeOrdered();

    List<Company> findAllByOrderByFounded();

    @Query("Select comp.industry, count(comp) from Company comp group by comp.industry")
    List<Object[]> countByIndustry();

    @Query("Select comp.size, count(comp) from Company comp group by comp.size")
    List<Object[]> countBySize();

    @Query("Select comp.founded, count(comp) from Company comp group by comp.founded order by comp.founded desc")
    List<Object[]> countByFounded();
}
