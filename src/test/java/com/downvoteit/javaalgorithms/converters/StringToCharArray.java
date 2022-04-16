package com.downvoteit.javaalgorithms.converters;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToCharArray extends SimpleArgumentConverter {
  @Override
  protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
    if (o == null) {
      return new char[] {};
    }
    if (!(o instanceof String)) {
      throw new ClassCastException("Cannot convert object");
    }

    String s = (String) o;
    String[] x1 = s.split(",");

    if (x1.length == 0 || x1[0].equals("")) {
      return new char[] {};
    }

    char[] x2 = new char[x1.length];

    for (int i = 0; i < x1.length; i++) {
      x2[i] = x1[i].strip().charAt(0);
    }

    return x2;
  }
}
