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

//    @Query("SELECT comp, (CASE WHEN (comp.size LIKE '10001+') THEN 1 WHEN (comp.size LIKE '5001-10000') THEN 2 WHEN (comp.size LIKE '1001-5000') THEN 3 WHEN (comp.size LIKE '501-1000') THEN 4 WHEN (comp.size LIKE '201-500') THEN 5 WHEN (comp.size LIKE '51-200') THEN 6 WHEN (comp.size LIKE '11-50') THEN 7 WHEN (comp.size LIKE '1-10') THEN 8 END) as ordSize FROM Company comp ORDER BY comp.size, ordSize DESC")
//    List<Company> findAllBySizeOrdered2();

    List<Company> findAllByOrderByFounded();

//    @Query(value = "select company.industry, count(*) from company.company group by company.industry", nativeQuery = true)
//    List<Object[]> countByIndustry();
//
//    @Query(value = "select company.size, count(*) from company.company group by company.size", nativeQuery = true)
//    List<Object[]> countBySize();
//
//    @Query(value = "select company.founded, count(*) from company.company group by company.founded", nativeQuery = true)
//    List<Object[]> countByFounded();

    @Query("Select comp.industry, count(comp) from Company comp group by comp.industry")
    List<Object[]> countByIndustry();

    @Query("Select comp.size, count(comp) from Company comp group by comp.size")
    List<Object[]> countBySize();

    @Query("Select comp.founded, count(comp) from Company comp group by comp.founded order by comp.founded desc")
    List<Object[]> countByFounded();
}
