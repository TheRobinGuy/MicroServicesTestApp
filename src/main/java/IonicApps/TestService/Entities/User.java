package IonicApps.TestService.Entities;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String UserName;
    private String Password;

    @Inject
    public User(UserBuilder userBuilder) {
        User user = new User.UserBuilder()
                .withUserName(userBuilder.UserName)
                .withPassword(userBuilder.Password)
                .build();
    }

    @Inject
    public User(String userName, String password) {
        this.UserName = userName;
        this.Password = password;
    }

    public class UserBuilder{
        private String UserName;
        private String Password;

        public UserBuilder withUserName(String userName){
            this.UserName = userName;
            return this;
        }

        public UserBuilder withPassword(String password){
            this.Password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
