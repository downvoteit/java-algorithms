package com.downvoteit.javaalgorithms.converters;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.ArrayList;
import java.util.List;

public class StringToIntList extends SimpleArgumentConverter {
  @Override
  protected List<Integer> convert(Object o, Class<?> aClass) throws ArgumentConversionException {
    if (o == null) {
      return new ArrayList<>();
    }
    if (!(o instanceof String)) {
      throw new ClassCastException("Cannot convert object");
    }

    String s = (String) o;
    String[] x1 = s.split(",");

    if (x1.length == 0 || x1[0].equals("")) {
      return new ArrayList<>();
    }

    List<Integer> x3 = new ArrayList<>();

    for (String x2 : x1) {
      x3.add(Integer.parseInt(x2.strip()));
    }

    return x3;
  }
}
