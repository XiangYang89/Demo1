package org.example.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId("uid")
    private Integer uid;
    private String uname;
    private String usex;
}
