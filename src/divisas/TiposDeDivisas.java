package divisas;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public record TiposDeDivisas(String base_code, Map<String, Double> conversion_rates) {

}
