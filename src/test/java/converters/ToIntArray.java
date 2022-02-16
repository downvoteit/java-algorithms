package converters;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ToIntArray extends SimpleArgumentConverter {
  @Override
  protected int[] convert(Object o, Class<?> aClass) throws ArgumentConversionException {
    if (o == null) {
      return new int[] {};
    }

    if (o instanceof String) {
      String[] x = ((String) o).split(",");

      int[] z = new int[x.length];

      for (int i = 0; i < x.length; i++) {
        z[i] = Integer.parseInt(x[i].strip());
      }

      return z;
    }

    throw new ClassCastException("Cannot convert object");
  }
}
