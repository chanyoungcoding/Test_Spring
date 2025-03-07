package study.spring.chan.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.spring.chan.domain.UserDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class UserService {

  Map<String, UserDTO> repository = new HashMap<>();

  // 유저 만들기
  public UserDTO createUser(String username, int age) {
    UserDTO user = new UserDTO(username, age);

    if(repository.containsKey(username)) {
      throw new IllegalArgumentException(username + "이 존재합니다.");
    }

    repository.put(username, user);
    return user;
  }

  // 유저 찾기
  public UserDTO findUser(String username) {
    return repository.get(username);
  }

  // 모든 유저 찾기
  public Collection<UserDTO> findAllUser() {
    return repository.values();
  }

  // 유저 업데이트
  public UserDTO updateUserAge(String username, int age) {
    UserDTO user = repository.get(username);

    user.setAge(age);
    repository.put(username, user);

    return user;
  }

  // 유저삭제
  public void deleteUser(String username) {
    log.info("유저가 삭제되었습니다. - {}", username);
    repository.remove(username);
  }

}
