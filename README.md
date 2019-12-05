# Jackson's Polymorphic Deserialization

This repo contains an abstract class `Animal`, which has two subtypes: `Cat` (with a boolean flag `canMeow`) and a `Dog`
(with a boolean flag `canBark`).

Serializing an object of `Cat` or `Dog` is no problem, because Jackson can find out the actual class at runtime. Problems
start when trying to deserialize the JSON.

Well,

```
Cat cat2 = mapper.readValue(catJson, Cat.class);
```

works, because of the `Cat.class` in the method call. But what if you want to read a JSON, which could contain a `Dog` or
a `Cat`?

```
Animal dog2 = mapper.readValue(dogJson, Animal.class);
```

For that you can use `@JsonTypeInfo`. Take a look at the [Animal class](src/main/java/de/mkammerer/jpd/Animal.java).

The JSON result looks like this:

```json
{
    "type" : "cat",
    "name" : "Ms. Cat",
    "canMeow" : true
}
```

```json
{
    "type" : "dog",
    "name" : "Mr. Dog",
    "canBark" : true
}
```
