package com.qiding.jiaguo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {

    @Bean
    public  GridFSBucket gridFSBucket(MongoClient mongoClient){
        MongoDatabase database=mongoClient.getDatabase("qiding-jiaguo-fs");
        return GridFSBuckets.create(database);
    }

}
