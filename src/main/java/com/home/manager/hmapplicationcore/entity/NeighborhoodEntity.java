package com.home.manager.hmapplicationcore.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import com.home.manager.hmapplicationcore.constants.RegionalPriceEnum;
import com.home.manager.hmapplicationcore.dto.PropertyDto;
import lombok.Data;

@Data
@DynamoDBTable(tableName = "neighborhood")
public class NeighborhoodEntity {

    private String id;
    private String name;
    private RegionalPriceEnum region;

    @DynamoDBHashKey
    public String getId() {
        return id;
    }

    @DynamoDBAttribute
    public String getName() {
        return name;
    }

    @DynamoDBAttribute
    @DynamoDBTypeConvertedEnum
    public RegionalPriceEnum getRegion() {
        return region;
    }


}
