package org.ersun.repository;

import org.ersun.model.Individual;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndividualRepository extends ElasticsearchRepository<Individual , String> {

    List<Individual> findByAd(String name);

    @Query("{\n" +
            "   \"bool\":{\n" +
            "      \"must\":[\n" +
            "         {\n" +
            "            \"match\":{\n" +
            "               \"ad\":\"?0\"\n" +
            "            }\n" +
            "         },\n" +
            "         {\n" +
            "            \"match\":{\n" +
            "               \"soyad\":\"?1\"\n" +
            "            }\n" +
            "         }\n" +
            "      ]\n" +
            "   }\n" +
            "}")
    List<Individual> findByAdSoyad(String ad , String soyad);

}
