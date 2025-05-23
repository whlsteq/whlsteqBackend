package whlsteq.backend.core.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValidationProblemDetails extends ProblemDetails{
    private Map<String,String> validationErrors;
}
