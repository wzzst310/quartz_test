package cn.wolfcode.quartz_test.webTest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LoginRsp {

    String userId;
    String authToken;
    private String phone;
    private String accountType;
    private String uuId;
    private Integer gestureCodeNum;
    private String userFlag;
    private String identificationStatus;
    private String imgUrl;
    private String faceStatus;
    private String email;
    private String userName;
    private String isFirstLogin;
}
