package converters;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringToDoubleArray extends SimpleArgumentConverter {
  @Override
  protected double[] convert(Object o, Class<?> aClass) throws ArgumentConversionException {
    if (o == null) {
      return new double[] {};
    }

    if (o instanceof String) {
      String[] x = ((String) o).split(",");

      if (x[0].equals("")) {
        return new double[] {};
      }

      double[] z = new double[x.length];

      for (int i = 0; i < x.length; i++) {
        z[i] = Double.parseDouble(x[i].strip());
      }

      return z;
    }

    throw new ClassCastException("Cannot convert object");
  }
}
