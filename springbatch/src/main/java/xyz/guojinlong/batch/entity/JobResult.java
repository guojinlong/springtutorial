package xyz.guojinlong.batch.entity;

import lombok.*;
import org.springframework.batch.core.ExitStatus;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@ToString(doNotUseGetters = true)
@AllArgsConstructor
@Builder
@Component
public class JobResult {
    private long jobId;
    private String jobName;
    private ExitStatus jobExitStatus;
    private long timestamp;
}
