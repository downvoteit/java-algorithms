package converters;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToDoubleArray extends SimpleArgumentConverter {
  @Override
  protected double[] convert(Object o, Class<?> aClass) throws ArgumentConversionException {
    if (o == null) {
      return new double[] {};
    }
    if (!(o instanceof String)) {
      throw new ClassCastException("Cannot convert object");
    }

    String s = (String) o;
    String[] x1 = s.split(",");

    if (x1.length == 0 || x1[0].equals("")) {
      return new double[] {};
    }

    double[] x2 = new double[x1.length];

    for (int i = 0; i < x1.length; i++) {
      x2[i] = Double.parseDouble(x1[i].strip());
    }

    return x2;
  }
}
