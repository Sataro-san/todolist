package kg.itacademy.securitylesson.repository;

import kg.itacademy.securitylesson.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUser_Login(String login);
    List<Task> findAllByTitleContainingIgnoringCase(String title);
    List<Task> findAllByTextContainingIgnoringCase(String text);
}
