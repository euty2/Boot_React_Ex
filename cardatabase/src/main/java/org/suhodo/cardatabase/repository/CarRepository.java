package org.suhodo.cardatabase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.suhodo.cardatabase.domain.Car;


@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

    // 브랜드로 자동차를 검색하는 Query Method/Rest 엔드포인트 등록
    List<Car> findByBrand(@Param("brand") String brand);

    // 색상으로 자동차를 검색하는 Query Method/Rest 엔드포인트 등록
    List<Car> findByColor(@Param("color") String color);
}
