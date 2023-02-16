import lombok.*;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Item<T> {
    private T first;
    private T second;
    private final UUID id;
}
