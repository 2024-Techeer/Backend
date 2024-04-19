package com.example.Backend.domain.user;

import com.example.Backend.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.crypto.password.PasswordEncoder;

//@NoArgsConstructor : 파라미터가 없는 디폴트 생성자를 생성
//@AllArgsConstructor : 모든 필드 값을 파라미터로 받는 생성자를 생성
//@RequiredArgsConstructor : final이나 @NonNull으로 선언된 필드만을 파라미터로 받는 생성자를 생성

@Document// @Document로 MongoDB 컬렉션과 매핑됨.
@Getter
@Setter
public class User extends BaseEntity {
    @Id// @Id 애노테이션은 MongoDB와 스프링 데이터에서 매우 중요한 역할을 함.이 애노테이션은 해당 필드가 문서의 기본 키(Primary Key)임을 나타냅니다.
    private String id;
    private String name;
    private String email;
    private String password;

    private String profileId; // Profile 문서의 ObjectId를 참조



    public User() {//기본 생성자
        super(); // BaseEntity의 생성자 호출
        //super() : 조상의 생성자 호출하는 것.(생성자=(인스턴스 초기화 메서드), 초기화블록은 상속되지 않기 때문.)
        //@NoArgsConstructor는 조상 생성자는 호출 못하므로 사용 불가
    }

    @Field("refresh_token")// MongoDB에서는 @Field를 사용하여 필드를 명시할 수 있습니다.
    private String refreshToken;
    //refreshtoken은 DB에저장, accesstoken은 ->stateless이므로 저장 X

    public void updateRefreshToken(String refreshToken){
        this.refreshToken=refreshToken;
    }
    public void destroyRefreshToken(){
        this.refreshToken=null;
    }


}
//MongoDB에서는 스키마가 고정되어 있지 않기 때문에, @Field 어노테이션과 같은 수단을 사용하여 필드 레벨에서 직접 not null 제약 조건을 적용할 수는 없습니다
//email필드 not null조건 어떻게 추가하지 그럼??