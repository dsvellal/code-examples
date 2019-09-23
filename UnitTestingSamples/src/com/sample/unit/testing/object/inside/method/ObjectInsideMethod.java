package com.sample.unit.testing.object.inside.method;

import java.util.List;

import com.sample.unit.testing.samples.pojo.CustomObject;

public class ObjectInsideMethod {
    public String objectInstantiationInsideMethod(List<String> listOfStrings) {
        return (new CustomObject(listOfStrings)).getListAsString();
    }

}
