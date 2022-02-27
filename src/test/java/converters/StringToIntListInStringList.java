package converters;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

import java.util.ArrayList;
import java.util.List;

public class StringToIntListInStringList extends SimpleArgumentConverter {
  @Override
  protected List<List<String>> convert(Object o, Class<?> aClass)
      throws ArgumentConversionException {
    if (o == null) {
      return new ArrayList<>();
    }
    if (!(o instanceof String)) {
      throw new ClassCastException("Cannot convert object");
    }

    String s = (String) o;
    String[] x1 = s.split("#");

    if (x1.length == 0 || x1[0].equals("")) {
      return new ArrayList<>();
    }

    List<List<String>> outer = new ArrayList<>();

    for (String x2 : x1) {
      List<String> inner = new ArrayList<>();

      String[] x3 = x2.split(",");

      if (x3[0].equals("")) {
        continue;
      }

      for (String x4 : x3) {
        inner.add(x4.strip());
      }

      outer.add(inner);
    }

    return outer;
  }
}
