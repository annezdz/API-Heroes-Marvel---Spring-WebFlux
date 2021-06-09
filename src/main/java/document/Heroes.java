package document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@DynamoDBTable(tableName = "Heroes_Tab")
public class Heroes {

    @Id
    @DynamoDBHashKey(attributeName = "id")
    private String id;

    @DynamoDBAttribute(attributeName = "name")
    private String name;

    @DynamoDBAttribute(attributeName = "universe")
    private String universe;

    @DynamoDBAttribute(attributeName = "films")
    private int films;

    @Deprecated
    public Heroes() { }

    public Heroes(String id, String name, String universe, int films) {
        this.id = id;
        this.name = name;
        this.universe = universe;
        this.films = films;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void setFilms(int films) {
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public String getUniverse() {
        return universe;
    }

    public int getFilms() {
        return films;
    }

    @Override
    public String toString() {
        return "Heroes{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", universe='" + universe + '\'' +
                ", films=" + films +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Heroes heroes = (Heroes) o;
        return films == heroes.films && Objects.equals(id, heroes.id) && Objects.equals(name, heroes.name) && Objects.equals(universe, heroes.universe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, universe, films);
    }
}
