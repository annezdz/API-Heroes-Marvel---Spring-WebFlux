package config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import static constants.HeroesConstant.ENDPOINT_DYNAMO;
import static constants.HeroesConstant.REGION_DYNAMO;


public class HeroesData {

    public static void main(String[] args) throws Exception{

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes");
        Item hero = new Item()
                .withPrimaryKey("id","1")
                .withString("name","Hulk")
                .withString("universe", "dc comics")
                .withNumber("films",3);

        Item hero1 = new Item()
                .withPrimaryKey("id","2")
                .withString("name","Thor")
                .withString("universe","dc comics")
                .withNumber("films",5);

        PutItemOutcome outcome = table.putItem(hero);
        PutItemOutcome outcome1 = table.putItem(hero1);

    }
}
