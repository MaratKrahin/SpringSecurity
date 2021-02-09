package springSec;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final String HELLO = "/hello";
    private static final String GET_COMMON_INFO = "/get-info/common";
    private static final String GET_USER_INFO = "/get-info/user";

    @GetMapping(HELLO)
    public ResponseEntity<String> getHello() {
        return ResponseEntity.status(HttpStatus.OK).body("hello");
    }

    @GetMapping(GET_COMMON_INFO)
    public ResponseEntity<String> getCommonInfo() {
        return ResponseEntity.status(HttpStatus.OK).body("common info");
    }

    @GetMapping(GET_USER_INFO)
    public ResponseEntity<String> getUserInfo() {
        return ResponseEntity.status(HttpStatus.OK).body("user info");
    }
}