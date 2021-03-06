package com.smartchoice.crawler.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerActivity {
    private String username;
    private LocalDateTime actionOn;
    private String viewProductId;
    private String searchKeyword;

    public CustomerActivity(String username, LocalDateTime actionOn, String viewProductId) {
        this.username = username;
        this.actionOn = actionOn;
        this.viewProductId = viewProductId;
        this.searchKeyword = viewProductId;
    }
}
