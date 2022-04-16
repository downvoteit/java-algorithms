package com.downvoteit.javaalgorithms.converters;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToIntArray extends SimpleArgumentConverter {
  @Override
  protected int[] convert(Object o, Class<?> aClass) throws ArgumentConversionException {
    if (o == null) {
      return new int[] {};
    }
    if (!(o instanceof String)) {
      throw new ClassCastException("Cannot convert object");
    }

    String s = (String) o;
    String[] x1 = s.split(",");

    if (x1.length == 0 || x1[0].equals("")) {
      return new int[] {};
    }

    int[] x2 = new int[x1.length];

    for (int i = 0; i < x1.length; i++) {
      x2[i] = Integer.parseInt(x1[i].strip());
    }

    return x2;
  }
}
