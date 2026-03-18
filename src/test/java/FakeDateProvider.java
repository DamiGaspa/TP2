import punto1.DateProvider;

import java.time.LocalDate;

public class FakeDateProvider implements DateProvider {
    @Override
    public LocalDate fecha() {
        return LocalDate.of(2026, 3, 18);
    }
}
