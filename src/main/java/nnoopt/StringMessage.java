package nnoopt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import nnoopt.AbstractMessage;

import java.time.LocalDateTime;

@EqualsAndHashCode (callSuper = true)
@Data
@AllArgsConstructor
public class StringMessage extends AbstractMessage {
    private String content;
    private LocalDateTime time;

}
